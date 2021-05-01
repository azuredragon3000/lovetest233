ObjectView1Spec(Point size) {
        super(size);
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;

        /* set up property view here */
        view = new PropertyView[4];

        view[0] = new PropertyView();
        setUpView(view[0],"background",
                "View",0,0,10,10,null);
        // java
        view[1] = new PropertyView();
        setUpView(view[1],"button",
                "View",6,2,9,4,null);

        // perl
        view[2] = new PropertyView();
        setUpView(view[2],"button",
                "View",6,4,9,6,null);

        // exit
        view[3] = new PropertyView();
        setUpView(view[3],"button",
                "View",6,6,9,8,null);

        return view;
    }
