package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import modelo.Alumno;
import vm.PrincipalModel;

public class PrincipalView extends SimpleWindow<PrincipalModel> {

	public PrincipalView(WindowOwner parent) {
		super(parent, new PrincipalModel());
	}

	@Override
	public void createContents(Panel Master) {
		Panel dataForm = new Panel(Master);
		Selector<Alumno> alumnoSelector = new Selector<Alumno>(dataForm).allowNull(true);
		alumnoSelector.bindItemsToProperty("alumnos");
		alumnoSelector.bindValueToProperty("alumnoElegido");

		Selector<Alumno> asignaturaSelector = new Selector<Alumno>(dataForm).allowNull(true);
		asignaturaSelector.bindItemsToProperty("asignaturas");
		asignaturaSelector.bindValueToProperty("asignaturaElegida");

	}

	@Override
	protected void addActions(Panel arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFormPanel(Panel arg0) {
		// TODO Auto-generated method stub

	}

}
