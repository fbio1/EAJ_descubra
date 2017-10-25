package br.eaj.tads.eaj_descubra;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerView implements android.support.v7.widget.RecyclerView.OnItemTouchListener {

    OnItemClickListener myListener;
    GestureDetector myGestureDetector;

    public interface OnItemClickListener {
        void OnItemClick(View view, int i);
        void OnItemLongClick(View view, int i);
    }

    public RecyclerView(Context c, final android.support.v7.widget.RecyclerView view, final OnItemClickListener myListener) {
        this.myListener = myListener;
        myGestureDetector = new GestureDetector(c, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                super.onSingleTapUp(motionEvent);
                View childView = view.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (childView != null && myListener !=null)
                    myListener.OnItemClick(childView, view.getChildAdapterPosition(childView));

                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {
        myGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(android.support.v7.widget.RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
