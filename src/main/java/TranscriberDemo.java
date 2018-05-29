import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class TranscriberDemo {

	public static void main(String[] args) throws Exception {
		Configuration configuration = new Configuration();

		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

		LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

		recognizer.startRecognition(true);
		SpeechResult result;

		while ((result = recognizer.getResult()) != null) {
			System.out.println("Best 3 hypothesis:");
			for (String s : result.getNbest(3)) {
				System.out.println(s);
			}

		}
		// recognizer.stopRecognition();
	}
}