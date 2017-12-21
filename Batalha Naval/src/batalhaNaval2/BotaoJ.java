package batalhaNaval2;

import javax.swing.JButton;

public class BotaoJ extends JButton {
		
		private int temBarco = 0;
		private boolean lock = false;
		
		public BotaoJ(){
			super();
		}

		protected int getTemBarco() {
			return temBarco;
		}

		protected void setTemBarco(int temBarco) {
			this.temBarco = temBarco;
		}
		protected boolean isLock() {
			return lock;
		}

		protected void setLock(boolean lock) {
			this.lock = lock;
		}

}
