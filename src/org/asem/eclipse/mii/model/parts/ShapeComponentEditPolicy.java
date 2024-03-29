/*******************************************************************************
 * Copyright (c) 2004, 2005 Elias Volanakis and others.
�* All rights reserved. This program and the accompanying materials
�* are made available under the terms of the Eclipse Public License v1.0
�* which accompanies this distribution, and is available at
�* http://www.eclipse.org/legal/epl-v10.html
�*
�* Contributors:
�*����Elias Volanakis - initial API and implementation
�*******************************************************************************/
package org.asem.eclipse.mii.model.parts;

import org.asem.eclipse.mii.model.abs.AbstractModelShape;
import org.asem.eclipse.mii.model.commands.ShapeDeleteCommand;
import org.asem.eclipse.mii.model.shapes.ShapesDiagram;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;


/**
 * This edit policy enables the removal of a Shapes instance from its container.
 * 
 * @see ShapeEditPart#createEditPolicies()
 * @see ShapeTreeEditPart#createEditPolicies()
 * @author Elias Volanakis
 */
class ShapeComponentEditPolicy extends ComponentEditPolicy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(
	 * org.eclipse.gef.requests.GroupRequest)
	 */
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		Object parent = getHost().getParent().getModel();
		Object child = getHost().getModel();
		if (parent instanceof ShapesDiagram && child instanceof AbstractModelShape) {
			return new ShapeDeleteCommand((ShapesDiagram) parent, (AbstractModelShape) child);
		}
		return super.createDeleteCommand(deleteRequest);
	}
}