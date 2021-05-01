  private ChangeView changeView;

    PropertyView[] pViews;
    private Rect[] rects;
    InputView3(EngineBroadcaster ger, ChangeView changeView) {
        ger.addObserver(this);
        this.changeView = changeView;
    }

    @Override
    public void setRects(PropertyView[] pViews) {
        this.pViews = pViews;
        rects = new Rect[pViews.length];
        for(int i=0;i<pViews.length;i++){
            rects[i] = pViews[i].position;
        }
    }

    @Override
    public void handleInput(MotionEvent event, int stage) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        if(stage == Constants.VIEW3) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    if (rects[14].contains(x, y)) {
                        Log.d("Debugview3", "rect1");
                        changeView.setView2();
                    }

                    if (rects[15].contains(x, y)) {
                        Log.d("Debugview3", "rect2");
                        changeView.setViewStart();
                    }

                    break;
            }
        }
    }
