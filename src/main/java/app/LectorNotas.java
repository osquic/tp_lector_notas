package app;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;

import ui.PrincipalView;

public class LectorNotas extends Application {

	public static void main(String[] args) {
		new LectorNotas().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		// TODO Auto-generated method stub
		return new PrincipalView(this);
		// return null;
	}

}
