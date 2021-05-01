  private ChangeView changeView;
    PropertyView[] pViews;
    private Rect[] rects;

    InputViewStart(EngineBroadcaster ger, ChangeView changeView) {
        ger.addObserver(this);
        this.changeView = changeView;
    }

    public void setRects(PropertyView[] pViews) {
        this.pViews = pViews;
        rects = new Rect[pViews.length];
        for(int i=0;i<pViews.length;i++){
            rects[i] = pViews[i].position;
        }
    }

    @Override
    public void handleInput(MotionEvent event,int stage) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        if(stage == Constants.VIEWSTART) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    if (rects[1].contains(x, y)) {
                        Log.d("DebugViewStart", "vao chuong trinh");
                        changeView.setView1();
                    }

                    if (rects[2].contains(x, y)) {
                        Log.d("DebugViewStart", "thoat");
                        //changeView.setView2(VIEW2);
                    }

                    break;
            }
        }
    }
