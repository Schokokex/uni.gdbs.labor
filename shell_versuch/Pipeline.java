import cTools.KernelWrapper;

public class Pipeline {
	private final static int READ = 0;
	private final static int WRITE = 1;

	private final SimpleCommand[] commands;
	private final int[][] pipes;

	public Pipeline(String userInput) throws Exception {
		final var splitString = userInput.split("\\|");
		commands = new SimpleCommand[splitString.length];
		for (int i = 0; i < splitString.length; i++) {
			commands[i] = new SimpleCommand(splitString[i]);
		}

		pipes = new int[commands.length - 1][2];
	}

	public void run() {
		switch (commands.length) {
		case 0:
			return;
		case 1:
			commands[0].run();
			return;
		default:
			for (final var cmd : commands) {
				cmd.run();
			}
		}

	}
	
	public void join() {
		for (final var cmd : commands) {
			cmd.join();
		}
	}


}
