package ui;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

import vm.NotasModel;

@SuppressWarnings("serial")
public class NotasView extends SimpleWindow<NotasModel> {

	public WindowOwner parentView;

	public NotasView(WindowOwner parent) {
		super(parent, new NotasModel());
		parentView = parent;
	}

	@Override
	public void createContents(Panel Master) {

		Panel dataForm = new Panel(Master);

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
