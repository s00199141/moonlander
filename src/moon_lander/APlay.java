package moon_lander;

import java.io.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class APlay extends JFrame {
	// available sounds
	public final int SOUND_CRASH = 1; // crash sound flag
	// add more sound flags here

	/* Constructor
	 * it is passed a sound flag
	 * it will play that sound
	 * there is only one currently supported.
	 * To use this sound - call new APlay(SOUND);
	 */
	public APlay(int soundRequired) {
		URL url;
		String soundFile = null;
		
		switch (soundRequired) {
		case SOUND_CRASH:
			soundFile = "moon_lander/resouces/sounds/drawing.wav";
			break;
			
		default :
			break;
			
		}

		// Go for it!
		try {
			// Open an audio input stream.
			url = this.getClass().getClassLoader().getResource(soundFile);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// TimeUnit.SECONDS.sleep(4); // delay the program while the sound
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}