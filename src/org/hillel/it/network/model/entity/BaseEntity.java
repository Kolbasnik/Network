package org.hillel.it.network.model.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 * 
 *This is basic class for all entities
 *
 */
public class  BaseEntity{
	protected int id;
	protected Calendar createDate;
	protected Calendar modifiedDate;
	protected User createBy;
	protected User modifiedBy;
	public static Calendar calendar=new GregorianCalendar();


	public BaseEntity () {
		if (createBy != null) {
			this.createDate = new GregorianCalendar();
			this.createDate.getTime();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}