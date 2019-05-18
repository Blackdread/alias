package org.alias.axon.serializer.example.query.model.member.nickname;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NicknameEntityKey implements Serializable {

	private static final long serialVersionUID = 6455008100544783181L;

	@Column(name = "NICKNAME", nullable = false)
	private String nickname;

	/**
	 * @deprecated JPA only
	 */
	@Deprecated
	public NicknameEntityKey() {
		super();
	}
	
	public NicknameEntityKey(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	@Override
	public boolean equals(final Object other) {
		if (other == null) {
			return false;
		}
		if (!getClass().equals(other.getClass())) {
			return false;
		}
		NicknameEntityKey castOther = (NicknameEntityKey) other;
		return Objects.equals(nickname, castOther.nickname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickname);
	}

	@Override
	public String toString() {
		return "NicknameEntityKey [nickname=" + nickname + "]";
	}
}