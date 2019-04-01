/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.quarkus.eclipse.ui.wizard;

import java.util.HashMap;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import io.quarkus.eclipse.ui.action.CreateProjectAction;

public class CreateProjectWizard extends Wizard implements INewWizard {
	
	private CreateProjectWizardPage createProjectWizardPage = null;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {}

	@Override
	public boolean performFinish() {
		new CreateProjectAction(
					createProjectWizardPage.getGroupId(), 
					createProjectWizardPage.getArtefactId(), 
					createProjectWizardPage.getVersion(), 
					createProjectWizardPage.getName(),
					new HashMap<String, Object>())
				.run();	
		return true;
	}

	public void addPages() {
		createProjectWizardPage = new CreateProjectWizardPage();
	    addPage(createProjectWizardPage);
	}
	
}
