/*
 * Copyright 2005-2014 Red Hat, Inc.
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.hornetq.tests.util;

import org.hornetq.api.core.client.ClientMessage;
import org.hornetq.api.core.client.ClientSession;
import org.hornetq.jms.client.HornetQBytesMessage;
import org.hornetq.jms.client.HornetQTextMessage;

public final class CreateMessage
{

   private CreateMessage()
   {
      // Utility class
   }

   public static ClientMessage createTextMessage(final String s, final ClientSession clientSession)
   {
      ClientMessage message = clientSession.createMessage(HornetQTextMessage.TYPE,
                                                          true,
                                                          0,
                                                          System.currentTimeMillis(),
                                                          (byte) 4);
      message.getBodyBuffer().writeString(s);
      return message;
   }

   public static ClientMessage createBytesMessage(final ClientSession session, final byte[] b, final boolean durable)
   {
      ClientMessage message = session.createMessage(HornetQBytesMessage.TYPE,
                                                    durable,
                                                    0,
                                                    System.currentTimeMillis(),
                                                    (byte) 1);
      message.getBodyBuffer().writeBytes(b);
      return message;
   }

   public static ClientMessage createTextMessage(final ClientSession session, final String s, final boolean durable)
   {
      ClientMessage message = session.createMessage(HornetQTextMessage.TYPE,
                                                    durable,
                                                    0,
                                                    System.currentTimeMillis(),
                                                    (byte) 1);
      message.getBodyBuffer().writeString(s);
      return message;
   }

}
