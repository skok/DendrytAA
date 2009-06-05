package com.dendrytdev.org.client.bean;

import com.dendrytdev.org.client.IUserInterfaceFactory;
import com.dendrytdev.org.client.UserInterfaceFactory;
import com.google.gwt.user.client.ui.Composite;

/*@                                    /\  /\
 * @                                  /  \/  \
 *  @                                /        --
 *   \---\                          /           \
 *    |   \------------------------/       /-\    \
 *    |                                    \-/     \ 
 *     \                                             ------O
 *      \         AlkoAgileDOG                            /
 *       |    |                    |    |                /
 *       |    |                    |    |-----    -------
 *       |    |\                  /|    |     \  WWWWWW/
 *       |    | \                / |    |      \-------
 *       |    |  \--------------/  |    |
 *      /     |                   /     |
 *      \      \                  \      \
 *       \-----/                   \-----/
 */
public enum Function{
	
	DESIGNER, 
	PROGRAMMER, 
	SERVICE, 
	TESTER, 
	CLIENT, 
	NOT_A_USER;

	public Composite getUserInterface() {
		IUserInterfaceFactory factory = new UserInterfaceFactory();
		switch (this) {
		case DESIGNER:
			return factory.generateDesignerInterface();
		case PROGRAMMER:
			return factory.generateProgrammerInterface();
		case SERVICE:
			return factory.generateServicerInterface();
		case TESTER:
			return factory.generateTesterInterface();
		case CLIENT:
			return factory.generateClientInterface();
		case NOT_A_USER:
			// TODO
		default:
			throw new RuntimeException(
					"internal error in getUserInterfaceFactory()");
		}

	}
}
