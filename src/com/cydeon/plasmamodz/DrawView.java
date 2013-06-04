package com.cydeon.plasmamodz;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DrawView extends View implements OnTouchListener{
    Paint paint = new Paint();
    public int bXP = 5;
    public int bYP = (600/2) - 100;
    public int bWP = 20;
    public int bHP = (600/2) + 100;
    public int bX = 1024/2 - 20/2;
    public int bY = 600/2 - 20/2;
    public int bW =  1024/2 + 20/2;
    public int bH = 600/2 + 20/2;
    public int bXP2 = 1004;
    public int bYP2 = (600/2) - 100;
    public int bWP2 = 1019;
    public int bHP2 = (600/2) + 100;
    public int score1, score2 = 0;
    public float pos1x = 1024/2 - 100;
    public float pos1y = 50;
    public float pos2x = 1024/2 + 100;
    
    private boolean isPlaying = true;
    private boolean bounceLeft, bounceRight, bounceRan1, bounceRan2, hitTop, hitBottom, bounceDown, bounceUp, hB100, hB300, hB500, hB800, hB1024 = false;
    Rect pad1 = new Rect(bXP, bYP, bWP, bHP);
    Rect ball = new Rect(bX, bY, bW, bH);
    
    
    
    public DrawView(Context context) {
        super(context);
        
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        
       // System.out.println(width + "   " + height);
        
        
    }

    @Override
    public void onDraw(Canvas canvas) {
    	//con = con.getApplicationContext();
    	//Toast.makeText(con, width, Toast.LENGTH_SHORT).show();
    	if(isPlaying){
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(0);
        canvas.drawRect(bXP, bYP, bWP, bHP, paint );
        canvas.drawRect(bXP2, bYP2, bWP2, bHP2, paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(bX, bY, bW, bH, paint);
        paint.setTextSize(50);
        canvas.drawText(Integer.toString(score1), pos1x, pos1y, paint);
        canvas.drawText(Integer.toString(score2), pos2x, pos1y, paint);
        checkLogic();
    	}
    	if(!isPlaying){
    		paint.setTextSize(canvas.getWidth()/10);
    		canvas.drawText("Play Pong!", canvas.getWidth()/6, canvas.getHeight()/12, paint);
    		
    	}
    }
    
   /* public void drawBall(int x, int y, int w, int h, Canvas canvas){
    	paint.setColor(Color.WHITE);
    	paint.setStrokeWidth(0);
    	x = bX;
    	y = bY;
    	w = bW;
    	h = bH;
    	canvas.drawRect(bX, bY, bW, bH, paint);
    } */
    
    public void checkLogic(){
    	Random r = new Random();
    	int dir = r.nextInt(18);
    	if(bX > 20 && bW > 20 && !bounceLeft){
    	setBottomFalse();
    	bX -= 10;
    	bW -= 10;
    	}
    	
    	//
    	if(bX < 20  && bH > bYP && bY < bHP){
    		if(bY > bYP && bH < bHP - (bHP/2)){
    	    	bX += 5;
    	    	bW += 5;
    	    	bY -= 15;
    	    	bH -= 15;
    	    	}if(bY > bYP + (bYP/2) && bH < bHP){
    	    		bX += 5;
    	        	bW += 5;
    	        	bY += 5;
    	        	bH += 5;
    	    	}
    		bounceLeft = true;
    		bounceRight = false;
    	}if(bounceLeft && hitTop && !hitBottom){
    		bY += 5;
    		bH += 5;
    		bX += 5;
    		bW += 5;
    	}if(bounceLeft && !hitTop){
    		if(bY < bYP && bH < bHP - (bHP/2)){
    	    	}if(bY > bYP + (bYP/2) && bH < bHP){
    	    		bounceDown = true;
    	    	}else if(bY > bYP + 70 && bH < bHP - 70){
    	    		bounceRan1 = true;
    			}else{
    	    		bounceUp = true;
    	    	}
    	}if(bounceDown){
    		bX += 5;
        	bW += 5;
        	bY += 5;
        	bH += 5;
    	}if(bounceUp){
    		bX += 10;
	    	bW += 10;
	    	bY -= 5;
	    	bH -= 5;
    	}if(bounceRan1){
    		bX += 5;
    		bW += 5;
    	}
    	
    	if(bounceLeft && !hitTop && hitBottom){
    		 if (hB100){
    			bH -= 10;
        		bY -= 10;
    			bX += 10;
        		bW += 10;
    		 }
    		}if(hB300){
    			bH -= 8;
        		bY -= 8;
    			bX += 8;
    			bW += 8;
    		}if(hB500){
    			bH -= 6;
        		bY -= 6;
    			bX += 6;
    			bW += 6;
    		}if(hB800){
    			bH -= 4;
        		bY -= 4;
    			bX += 4;
    			bW += 4;
    		}if(hB1024){
    			bH -= 2;
        		bY -= 2;
    			bX += 2;
    			bW += 2;
    		}
    		
    		/*if(dir == 1 || dir == 3 || dir == 7){
    			bY -= 1;
        		bH -= 1;
    		}else if(dir == 2 || dir == 5){
    			bY += 1;
    			bH += 1;
    		}else if(dir == 0 || dir == 4 || dir == 8){
    			bY -= 2;
    			bH -= 2;
    		}else if (dir == 6 || dir == 9 || dir == 10){
    			bY += 2;
    			bH += 2;
    		}else if (dir == 11 || dir == 12){
    			bY -= 5;
    			bH -= 5;
    		}else if (dir == 13){
    			bY += 4;
    			bH += 4;
    		}else if (dir == 14){
    			bY -= 8;
    			bH -= 8;
    		}else if (dir == 15){
    			bY += 7;
    			bH += 7;
    		}else if (dir == 16){
    			bY += 10;
    			bH += 10;
    		}else if (dir == 17){
    			bY += 12;
    			bH += 12;
    		}else if (dir == 18){
    			bY += 7;
    			bH += 7;
    		}*/
    		if(bX > 990 && bY > bYP2 && bH < bHP2){
    		bounceLeft = false;
    		bX -= 5;
    		bW -= 5;
    		bounceRight = true;
    	}if(bX > 1000){
    		score1++;
    		bX = 1024/2 - 20/2;
    	    bY = 600/2 - 20/2;
    	    bW =  1024/2 + 20/2;
    	    bH = 600/2 + 20/2;
    	    bounceLeft = false;
    	    bounceRight = false;
    	}if(bounceRight){
    		bX -= 1;
    		bW -= 1;
    	}if(bYP2 < 0){
    		bYP2 = 0;
    		bHP2 = 200;
    	}if(bYP < 0){
    		bYP = 0;
    		bHP = 200;
    	}if(bHP > 600){
    		bHP = 600;
    		bYP = 400;
    	}if(bY < 0 && bounceLeft){
    		hitTop = true;
    		setBottomFalse();
    		bY += 5;
    		bH += 5;
    	}if(bH > 600){
    		hitTop = false;
    		if(bX < 100 && bX > 0){
    			hB100 = true;
    		}if(bX < 300 && bX > 101){
    			hB300 = true;
    		}if(bX < 500 && bX > 301){
    			hB500 = true;
    		}if(bX < 800 && bX > 501){
    			hB800 = true;
    		}if(bX <= 1024 && bX > 801){
    			hB1024 = true;
    		}
    		hitBottom = true;

    		if(bX < 100 && bX > 0){
    			bH -= 10;
        		bY -= 10;
    			bX += 10;
        		bW += 10;
    		}if(bX < 300 && bX > 101){
    			bH -= 8;
        		bY -= 8;
    			bX += 8;
    			bW += 8;
    		}if(bX < 500 && bX > 301){
    			bH -= 6;
        		bY -= 6;
    			bX += 6;
    			bW += 6;
    		}if(bX < 800 && bX > 501){
    			bH -= 4;
        		bY -= 4;
    			bX += 4;
    			bW += 4;
    		}if(bX <= 1024 && bX > 801){
    			bH -= 2;
        		bY -= 2;
    			bX += 2;
    			bW += 2;
    		}
    	}if(!bounceLeft && bX < 20){
    		bX -= 5;
    		bW -= 5;
    	}if(bX < 0){
    		score2++;
    		bX = 1024/2 - 20/2;
    	    bY = 600/2 - 20/2;
    	    bW =  1024/2 + 20/2;
    	    bH = 600/2 + 20/2;
    	    	bX -= 5;
        	    bW -= 5;
    	    
    	}if(bX < 20 && bHP + bYP > bY){
    		bX -= 5;
    		bW -= 5;
    	}
		//bYP2 -= 1;
		//bHP2 -= 1;
    	//Artificial Intelligence
    	if(bY < 50){
    		bYP2 -= 4;
    		bHP2 -= 4;
    	}if(bY < 150 && bY > 50){
    		bYP2 -= 5;
    		bHP2 -= 5;
    	}if(bY < 250 && bY > 150){
    		bYP2 += 1;
    		bHP2 += 1;
    	}if(bY < 300 && bY > 250){
    		bYP2 -= 0;
    		bHP2 -= 0;
    	}if(bY < 400 && bY > 300){
    		bYP2 -= 2;
    		bHP2 -= 2;
    	}if(bY < 500 && bY > 400){
    		bYP2 += 4;
    		bHP2 += 4;
    	}if(bY < 600 && bY > 500){
    		bYP2 += 5;
    		bHP2 += 5;
    	}if(bHP2 > 600){
    		bYP2 = 400;
    		bHP2 = 600;
    	}if(bY > 250 && bH < 350){
    		bYP2 += 0;
    		bHP2 += 0;
    	}if(bHP2 > 500 && bX < 600){
    		bYP2 -= 5;
    		bHP2 -= 5;
    		if(bYP2 < 200){
    			bYP2 = 200;
    			bHP2 = 400;
    		}
    	}
    	//Loop the onDraw() method
    	invalidate();
    }

    public void setBottomFalse(){
    	hitBottom = false;
		hB100 = false;
		hB100 = false;
		hB300 = false;
		hB500 = false;
		hB800 = false;
		hB1024 = false;
		bounceDown = false;
		bounceUp = false;
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		//if(!isPlaying)
		//	isPlaying = true;
		bYP = (int) event.getY() - 100;
		bHP = (int) event.getY() + 100;
		invalidate();
		switch(event.getAction()){
		case MotionEvent.ACTION_MOVE:
			bYP = (int) event.getY() - 100;
			bHP = (int) event.getY() + 100;
		if(bYP < 0){
    		bYP = 0;
    		bHP = 200;
    	}if(bHP > 600){
    		bHP = 600;
    		bYP = 400;
    	}
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			
		}
		return true;
	}
    

}