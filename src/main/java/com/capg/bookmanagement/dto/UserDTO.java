package com.capg.bookmanagement.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "User")
@IdClass(UserDTO.class)
public class UserDTO implements Serializable {
	
		@Id
		@Column(name = "user_id" ,nullable=false)
		private String userId;
		
		@Column(name= "book_id" ,nullable=false)
		private String bookId;
		public UserDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDTO(String userId, String bookId) {
			super();
			this.userId = userId;
			this.bookId = bookId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getBookId() {
			return bookId;
		}
		public void setBookId(String bookId) {
			this.bookId = bookId;
		}
		@Override
		public String toString() {
			return "UserDTO [userId=" + userId + ", bookId=" + bookId + "]";
		}

}
