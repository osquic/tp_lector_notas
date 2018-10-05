package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import vm.DatosModel;

@SuppressWarnings("serial")
public class DatosView extends SimpleWindow<DatosModel> {

	public WindowOwner parentView;

	public DatosView(WindowOwner parent) {
		super(parent, new DatosModel());
		parentView = parent;
		this.getModelObject().setLegajoSeleccionado(((PrincipalView) parentView).getModelObject().getLegajoIngresado());
		this.getModelObject().setTokenIngresado(((PrincipalView) parentView).getModelObject().getTokenIngresado());
		this.getModelObject().cargarDatosAlumnoSeleccionado();
	}

	@Override
	public void createContents(Panel Master) {

		// Panel Mostrar Datos
		Panel mostrarDatosForm = new Panel(Master);
		mostrarDatosForm.setLayout(new ColumnLayout(2));
		// Nombre
		new Label(mostrarDatosForm).setText("Nombre: ");
		TextBox nombreBox = new TextBox(mostrarDatosForm);
		nombreBox.bindValueToProperty("alumnoSeleccionado.nombre");
		nombreBox.bindEnabledToProperty("permiteEditar");
		// Apellido
		new Label(mostrarDatosForm).setText("Apellido: ");
		TextBox apellidoBox = new TextBox(mostrarDatosForm);
		apellidoBox.bindValueToProperty("alumnoSeleccionado.apellido");
		apellidoBox.bindEnabledToProperty("permiteEditar");
		// Legajo
		new Label(mostrarDatosForm).setText("Legajo: ");
		TextBox legajoBox = new TextBox(mostrarDatosForm);
		legajoBox.bindValueToProperty("alumnoSeleccionado.legajo");
		legajoBox.bindEnabledToProperty("siempreDisabled");
		
		// Usuario
		new Label(mostrarDatosForm).setText("Usuario Git: ");
		TextBox usuarioBox = new TextBox(mostrarDatosForm);
		usuarioBox.bindValueToProperty("alumnoSeleccionado.usuarioGit");
		usuarioBox.bindEnabledToProperty("permiteEditar");

		// Panel Botones
		Panel botonesForm = new Panel(Master);
		botonesForm.setLayout(new HorizontalLayout());
		new Button(botonesForm).setCaption("Editar").onClick(() -> this.getModelObject().habilitarEdicion());
		new Button(botonesForm).setCaption("Guardar").onClick(() -> this.getModelObject().guardarDatos());

		// Panel Exit
		Panel cerrarForm = new Panel(Master);
		new Button(cerrarForm).setCaption("Cerrar").onClick(() -> this.close());

	}

	@Override
	protected void addActions(Panel actionsPanel) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		// TODO Auto-generated method stub
	}

}
