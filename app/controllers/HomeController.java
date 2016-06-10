package controllers;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;


import com.fasterxml.jackson.databind.JsonNode;

import models.MasterData;
import models.ProductInfo;
import play.Logger;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result index() {
		return ok(views.html.index.render());
	}

	public Result getProduct() {
		JsonNode json = request().body().asJson();
		String status = json.get("status").textValue();
		Logger.info(status);
		if (status.equals("taken")) {
			Logger.info("reached here");
			for (JsonNode json1 : json.withArray("data")) {

				String barcode = json1.get("barcode").textValue();
				Logger.info(barcode);
				String date = json1.get("date").textValue();
				String image = json1.get("image").textValue();

				ProductInfo prod = MorphiaObject.datastore.find(ProductInfo.class).field("Selling Unit Barcode")
						.equal(barcode).get();
				Logger.info("Object RPC:" + prod);
				if (prod == null || prod.getProductID() == "" || prod.getRPC() == "") {
					MasterData md = new MasterData();
					md.setImage(image);
					md.setDate(date);
					md.setBarcode(barcode);
					MorphiaObject.datastore.save(md);
				} else {
					if (prod.getPhotoTaken() == null ||  prod.getPhotoTaken() == false) {
						prod.setPhotoTaken(true);
						prod.setPhotoTakenDate(date);
					}
				}
			}
		} else if (status.equals("edited")) {
			for (JsonNode json1 : json.withArray("data")) {
				String barcode = json1.get("productID").textValue();
				Logger.info(barcode);
				String date = json1.get("photoEditedDate").textValue();
 
				// ProductInfo prod = MorphiaObject.datastore.find(ProductInfo.class).field("Selling Unit Barcode")
				// 		.equal(barcode).get();
				// Logger.info("Object RPC:" + prod);
				// if (prod.getPhotoEdited() ==null || prod.getPhotoEdited() == false) {
					 
					UpdateOperations<ProductInfo> upOps = MorphiaObject.datastore.createUpdateOperations(ProductInfo.class);
					upOps.set("Photo Edited", true); 
					upOps.set("Photo Edited Date", date); 

					Query<ProductInfo> prod = MorphiaObject.datastore.find(ProductInfo.class);	
				    prod.field("Selling Unit Barcode").equal(barcode);
				    MorphiaObject.datastore.update(prod, upOps);

				// }
			}
		}
		return ok("{\"success\":true}").as("application/json");
	}
	public Result getAllProducts(){
		JsonNode node=null;

		Query<ProductInfo> prod = MorphiaObject.datastore.find(ProductInfo.class);
		prod.and(prod.criteria("Photo Taken").equal(true), prod.criteria("Photo Edited").equal(true),
				prod.criteria("Photo Uploaded").equal(true));
//		if(prod.field("Product ID").exists() != null){
//		prod.order("Product ID");
//		node = Json.toJson(prod.asList());
//		}
		return ok(node).as("application/json");
	}
	public Result getNonEditedProducts() {
		boolean var = request().getQueryString("edited").equals("false"); 

		JsonNode node = null;
		if (var == true) { 
			Query<ProductInfo> prod = MorphiaObject.datastore.find(ProductInfo.class);
			prod.and(prod.criteria("Photo Taken").equal(true), prod.criteria("Photo Edited").equal(false)
					); 
			node = Json.toJson(prod.asList());

		}
		return ok(node).as("application/json");
	}

	public Result updateProduct(int id) {
		Logger.info("Product Update ID:" + id);
		return ok();
	}
}
