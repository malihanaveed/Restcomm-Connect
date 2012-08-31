/*
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.servlet.sip.restcomm;

import java.util.UUID;
import java.util.regex.Pattern;

import org.mobicents.servlet.sip.restcomm.annotations.concurrency.Immutable;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@Immutable public final class Sid{
  private static final Pattern pattern = Pattern.compile("[a-zA-Z0-9]{34}");
  private final String id;
  public enum Type {ACCOUNT, APPLICATION, CALL, CLIENT, CONFERENCE, NOTIFICATION, PHONE_NUMBER, RECORDING, SHORT_CODE, SMS_MESSAGE, TRANSCRIPTION};
  
  public Sid(final String id) throws IllegalArgumentException {
    super();
    if(pattern.matcher(id).matches()) {
      this.id = id;
    } else {
      throw new IllegalArgumentException(id + " is an invalid sid value.");
    }
  }

  @Override public boolean equals(Object object) {
	if(this == object) {
	  return true;
	}
	if(object == null) {
	  return false;
	}
	if(getClass() != object.getClass()) {
	  return false;
	}
	final Sid other = (Sid)object;
	if(!toString().equals(other.toString())) {
	  return false;
	}
	return true;
  }
  
  public static Sid generate(final Type type) {
	final String uuid = UUID.randomUUID().toString().replace("-", "");
    switch(type) {
      case ACCOUNT: {
        return new Sid("AC" + uuid);
      }
      case APPLICATION: {
        return new Sid("AP" + uuid);
      }
      case CALL: {
        return new Sid("CA" + uuid);
      }
      case CLIENT: {
        return new Sid("CL" + uuid);
      }
      case CONFERENCE: {
        return new Sid("CF" + uuid);
      }
      case NOTIFICATION: {
        return new Sid("NO" + uuid);
      }
      case PHONE_NUMBER: {
        return new Sid("PN" + uuid);
      }
      case RECORDING: {
        return new Sid("RE" + uuid);
      }
      case SHORT_CODE: {
        return new Sid("SC" + uuid);
      }
      case SMS_MESSAGE: {
        return new Sid("SM" + uuid);
      }
      case TRANSCRIPTION: {
        return new Sid("TR" + uuid);
      }
      default: {
        return null;
      }
    }
  }

  @Override public int hashCode() {
	final int prime = 5;
	int result = 1;
	result = prime * result + id.hashCode();
	return result;
  }

  @Override public String toString() {
    return id;
  }
}
