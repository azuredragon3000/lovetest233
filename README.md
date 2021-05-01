 ObjectViewStartSpec(Point size) {
        super(size);
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;
        Rect Rtemp = new Rect();
        /* set up property view here */
        view = new PropertyView[3];

        view[0] = new PropertyView();
        view[0].bg = "background";
        view[0].typeView = "View";
        view[0].position = new Rect(0,0,x,y);

        view[1] = new PropertyView();
        view[1].bg = "button";
        view[1].typeView = "View";
        Rtemp = getRect(1,6,4,8);
        view[1].position = new Rect(Rtemp);

        view[2] = new PropertyView();
        view[2].bg = "button";
        view[2].typeView = "View";
        Rtemp = getRect(6,6,9,8);
        view[2].position = new Rect(Rtemp);

        return view;
    }
