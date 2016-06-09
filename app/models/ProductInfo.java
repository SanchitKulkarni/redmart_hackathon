package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

import java.util.*;
@Entity("salsify")
public class ProductInfo {
	@Property("Selling Unit Barcode")
	private String ProductID;
	@Property("RPC")
	private String RPC;
	@Property("Photo Taken")
	private Boolean PhotoTaken;
	@Property("Photo Taken Date")
	private String PhotoTakenDate;
	@Property("Photo Edited")
	private Boolean PhotoEdited;
	@Property("Photo Edited Date")
	private String PhotoEditedDate;
	@Property("Photo Uploaded")
	private Boolean PhotoUpdated;
	@Property("Photo Uploaded - Date")
	private String PhotoUpdatedDate;
	public String getProductID() {
		return ProductID;
	}
	public void setProductID(String productID) {
		ProductID = productID;
	}
	public String getRPC() {
		return RPC;
	}
	public void setRPC(String rPC) {
		RPC = rPC;
	}
	public Boolean getPhotoTaken() {
		return PhotoTaken;
	}
	public void setPhotoTaken(Boolean photoTaken) {
		PhotoTaken = photoTaken;
	}
	public String getPhotoTakenDate() {
		return PhotoTakenDate;
	}
	public void setPhotoTakenDate(String photoTakenDate) {
		PhotoTakenDate = photoTakenDate;
	}
	public Boolean getPhotoEdited() {
		return PhotoEdited;
	}
	public void setPhotoEdited(Boolean photoEdited) {
		PhotoEdited = photoEdited;
	}
	public String getPhotoEditedDate() {
		return PhotoEditedDate;
	}
	public void setPhotoEditedDate(String photoEditedDate) {
		PhotoEditedDate = photoEditedDate;
	}
	public Boolean getPhotoUpdated() {
		return PhotoUpdated;
	}
	public void setPhotoUpdated(Boolean photoUpdated) {
		PhotoUpdated = photoUpdated;
	}
	public String getPhotoUpdatedDate() {
		return PhotoUpdatedDate;
	}
	public void setPhotoUpdatedDate(String photoUpdatedDate) {
		PhotoUpdatedDate = photoUpdatedDate;
	}
	
}
