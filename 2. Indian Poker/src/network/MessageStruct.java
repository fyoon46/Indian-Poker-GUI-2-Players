package network;

import java.io.Serializable;

/**
 * Message Struct
 *
 * A structure of messages for communication between server and client
 *
 * Message types and description
 * 		type	description						direction
 * 		0		both players accepted			server -> client
 * 		1		return client instance  		client -> server
 *		2		sends a message     			server -> client
 *	    3       request rock scissor paper      server -> client
 *	    4       update player info              server -> client
 */

public class MessageStruct implements Serializable {
    private static final long serialVersionUID = 3532734764930998421L;
    public int _code;
    public Object _content;

    public MessageStruct() {
        this._code = 0;
        this._content = 0;
    }

    public MessageStruct(int code, Object content) {
        this._code = code;
        this._content = content;
    }
}
