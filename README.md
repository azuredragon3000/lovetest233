 private ChangeView changeView;
    private TypeQuestion question;
    PropertyView[] pViews;
    private Rect[] rects;
    InputView1(EngineBroadcaster ger, ChangeView changeView, TypeQuestion question) {
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
    public void handleInput(MotionEvent event,int stage) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        if(stage == Constants.VIEW1) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    if (rects[1].contains(x, y)) {
                        Log.d("Debugview1", "java");
                        changeView.setView3("Java");
                    }

                    if (rects[2].contains(x, y)) {
                        Log.d("Debugview1", "perl");
                        changeView.setView3("Perl");
                    }

                    if (rects[3].contains(x, y)) {
                        Log.d("Debugview1", "thoat");
                        changeView.setViewStart();
                    }

                    break;
            }
        }
    }
