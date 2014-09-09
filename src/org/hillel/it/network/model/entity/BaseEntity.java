package org.hillel.it.network.model.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *This is basic class for all entities
 */
public class  BaseEntity{
	protected int id;
	protected Calendar createDate;
	protected Calendar modifiedDate;
	protected int createBy;
	protected int modifiedBy;
	public static Calendar calendar=new GregorianCalendar();


	public BaseEntity () {
		if (createBy != 0) {
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

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}