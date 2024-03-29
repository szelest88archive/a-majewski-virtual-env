package edu.dhbw.andar.sample;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import edu.dhbw.andar.AndARRenderer;
import edu.dhbw.andar.interfaces.OpenGLRenderer;
import edu.dhbw.andar.util.GraphicsUtil;


public class CustomRenderer extends Activity implements OpenGLRenderer {

	
	private float[] ambientlight1 = {.3f, .3f, .3f, 1f};
	public float[] diffuselight1 = {.7f, .7f, .7f, 1f};
	private float[] specularlight1 = {0.6f, 0.6f, 0.6f, 1f};
	private float[] lightposition1 = {20.0f,-40.0f,100.0f,1f};
	
	private FloatBuffer lightPositionBuffer1 =  GraphicsUtil.makeFloatBuffer(lightposition1);
	private FloatBuffer specularLightBuffer1 = GraphicsUtil.makeFloatBuffer(specularlight1);
	private FloatBuffer diffuseLightBuffer1 = GraphicsUtil.makeFloatBuffer(diffuselight1);
	private FloatBuffer ambientLightBuffer1 = GraphicsUtil.makeFloatBuffer(ambientlight1);
	
	/**
	 * Do non Augmented Reality stuff here. Will be called once after all AR objects have
	 * been drawn. The transformation matrices may have to be reset.
	 */
	public final void draw(GL10 gl) {
		/*//jak co�, to zapisa� stan macierzy przedtem, zrobi� orto i przywr�ci� potem
		AgainBox a = new AgainBox();
		for(int i=0;i<4;i++)
		{
//			gl.glPushMatrix();
			gl.glTranslatef(15f,0f, 0);
		gl.glPushMatrix();
			gl.glScalef(0.2f,0.2f,0.2f);
		a.draw(gl);
		gl.glPopMatrix();
		}
		*/
	}


	/**
	 * Directly called before each object is drawn. Used to setup lighting and
	 * other OpenGL specific things.
	 */
	public final void setupEnv(GL10 gl) {
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, ambientLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, diffuseLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_SPECULAR, specularLightBuffer1);
		gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_POSITION, lightPositionBuffer1);
		gl.glEnable(GL10.GL_LIGHT1);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	    gl.glDisable(GL10.GL_TEXTURE_2D);
		initGL(gl);
	
	}
	
	/**
	 * Called once when the OpenGL Surface was created.
	 */
	public final void initGL(GL10 gl) {
		
	//	gl.glDisable(GL10.GL_COLOR_MATERIAL);
		//gl.glEnable(GL10.GL_CULL_FACE);
		gl.glShadeModel(GL10.GL_SMOOTH);
//		gl.glDisable(GL10.GL_COLOR_MATERIAL);
		gl.glEnable(GL10.GL_LIGHTING);
	//	gl.glEnable(GL10.GL_CULL_FACE);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glEnable(GL10.GL_NORMALIZE);
		
	}


	
}
