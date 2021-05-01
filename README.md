 private ChangeView changeView;
    private PropertyView[] pViews;
    private Rect[] rects;

    InputView2(EngineBroadcaster ger, ChangeView changeView) {
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

        if(stage == Constants.VIEW2) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    

                    if (rects[18].contains(x, y)) {
                        Log.d("Debugview2", "exit");
                        changeView.setViewStart();
                    }
                    break;
            }
        }
    }
