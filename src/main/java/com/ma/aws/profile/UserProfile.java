package com.ma.aws.profile;

import java.util.Objects;
import java.util.UUID;

public class UserProfile {
	private UUID uuid;
	private String userName;
	private String userprofileImageLink;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserprofileImageLink() {
		return userprofileImageLink;
	}
	public void setUserprofileImageLink(String userprofileImageLink) {
		this.userprofileImageLink = userprofileImageLink;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userprofileImageLink == null) ? 0 : userprofileImageLink.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!Objects.equals(userName, other.userName))
			return false;
		if (userprofileImageLink == null) {
			if (other.userprofileImageLink != null)
				return false;
		} else if (!Objects.equals(userprofileImageLink, other.userprofileImageLink))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!Objects.equals(uuid, other.uuid))
			return false;
		return true;
	}
	
	
}
