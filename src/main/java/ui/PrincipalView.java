package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import vm.PrincipalModel;

@SuppressWarnings("serial")
public class PrincipalView extends SimpleWindow<PrincipalModel> {

	public PrincipalView(WindowOwner parent) {
		super(parent, new PrincipalModel());
	}

	@Override
	public void createContents(Panel Master) {

		// Panel Master
		this.setTitle("Lector de Notas");
		new Label(Master).setText("Lector de Notas").setFontSize(14);

		// Login
		new Label(Master).setText("Ingrese su legajo").setFontSize(10);
		new TextBox(Master).setWidth(100).bindValueToProperty("legajoIngresado");
		new Button(Master).setCaption("Ingresar").onClick(() -> this.getModelObject().chequearLegajo());
		new Label(Master);

		// Panel Botones Consulta
		Panel botonesForm = new Panel(Master);
		botonesForm.setLayout(new ColumnLayout(2));

		Button botonNotas = new Button(botonesForm);
		botonNotas.setCaption("Consultar Notas");
		// botonNotas.setWidth(100);
		botonNotas.onClick(() -> new NotasView(this).open());
		botonNotas.bindEnabledToProperty("existeLegajo");

		Button botonDatos = new Button(botonesForm);
		botonDatos.setCaption("Consultar Datos");
		// botonDatos.setWidth(100);
		botonDatos.onClick(() -> new DatosView(this).open());
		botonDatos.bindEnabledToProperty("existeLegajo");

		// Panel Exit
		Panel cerrarForm = new Panel(Master);
		new Button(cerrarForm).setCaption("Cerrar").onClick(() -> this.close());

		// Ingrese Legajo
		// new Label(dataForm).setText("Ingrese su Legajo:").setFontSize(11);
		//
		// Selector<Alumno> alumnoSelector = new
		// Selector<Alumno>(dataForm).allowNull(true);
		// alumnoSelector.bindItemsToProperty("alumnos");
		// alumnoSelector.bindValueToProperty("alumnoElegido");
		//
		// Selector<Alumno> asignaturaSelector = new
		// Selector<Alumno>(dataForm).allowNull(true);
		// asignaturaSelector.bindItemsToProperty("asignaturas");
		// asignaturaSelector.bindValueToProperty("asignaturaElegida");

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
