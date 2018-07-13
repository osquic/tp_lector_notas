package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import modelo.Asignatura;
import vm.NotasModel;

@SuppressWarnings("serial")
public class NotasView extends SimpleWindow<NotasModel> {

	public WindowOwner parentView;

	public NotasView(WindowOwner parent) {
		super(parent, new NotasModel());
		parentView = parent;
		this.getModelObject().setLegajoSeleccionado(((PrincipalView) parentView).getModelObject().getLegajoIngresado());
		this.getModelObject().cargarDatosAlumnoSeleccionado();
	}

	@Override
	public void createContents(Panel Master) {

		// Panel Mostrar Notas
		Panel mostrarDatosForm = new Panel(Master);
		mostrarDatosForm.setLayout(new ColumnLayout(2));
		// Nombre
		new Label(mostrarDatosForm).setText("Nombre: ");
		TextBox nombreBox = new TextBox(mostrarDatosForm);
		nombreBox.bindValueToProperty("alumnoSeleccionado.nombre");
		// Apellido
		new Label(mostrarDatosForm).setText("Apellido: ");
		TextBox apellidoBox = new TextBox(mostrarDatosForm);
		apellidoBox.bindValueToProperty("alumnoSeleccionado.apellido");

		// Selector de Asignaturas
		Panel selectorPanel = new Panel(Master);
		selectorPanel.setLayout(new ColumnLayout(2));
		new Label(selectorPanel).setText("Selector de Asignaturas");
		Selector<Asignatura> selectorDeAsignaturas = new Selector<Asignatura>(selectorPanel).allowNull(true);
		selectorDeAsignaturas.setWidth(100);
		selectorDeAsignaturas.bindItemsToProperty("asignaturas");
		selectorDeAsignaturas.bindValueToProperty("asignaturaSeleccionada");

		Panel datosAsignatura = new Panel(Master);

		// Ultima calificacion
		new Label(datosAsignatura).setText("Calificacion: ");
		TextBox calificacionBox = new TextBox(mostrarDatosForm);
		calificacionBox.bindValueToProperty("calificacion");

		// Estado
		new Label(datosAsignatura).setText("Estado: ");
		TextBox estadoBox = new TextBox(mostrarDatosForm);
		estadoBox.bindValueToProperty("estado");

		// Panel Botones

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
