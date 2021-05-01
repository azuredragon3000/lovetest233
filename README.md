ObjectView3Spec(Point size) {
        super(size);
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;

        /* set up property view here */
        view = new PropertyView[16];

        view[0] = new PropertyView();
        setUpView(view[0],"background",
                "View",0,0,10,10,null);

        /* 10 bt side */
        view[1] = new PropertyView();
        setUpView(view[1],"button",
                "View",8,0,10,1,null);
        view[2] = new PropertyView();
        setUpView(view[2],"button",
                "View",8,1,10,2,null);
        view[3] = new PropertyView();
        setUpView(view[3],"button",
                "View",8,2,10,3,null);
        view[4] = new PropertyView();
        setUpView(view[4],"button",
                "View",8,3,10,4,null);
        view[5] = new PropertyView();
        setUpView(view[5],"button",
                "View",8,4,10,5,null);
        view[6] = new PropertyView();
        setUpView(view[6],"button",
                "View",8,5,10,6,null);
        view[7] = new PropertyView();
        setUpView(view[7],"button",
                "View",8,6,10,7,null);
        view[8] = new PropertyView();
        setUpView(view[8],"button",
                "View",8,7,10,8,null);
        view[9] = new PropertyView();
        setUpView(view[9],"button",
                "View",8,8,10,9,null);
        view[10] = new PropertyView();
        setUpView(view[10],"button",
                "View",8,9,10,10,null);

        view[11] = new PropertyView();
        setUpView(view[11],"view level",
                "TextView",1,0,3,1,null);

        view[12] = new PropertyView();
        setUpView(view[12],"view point",
                "TextView",4,0,6,1,null);

        view[13] = new PropertyView();
        setUpView(view[13],"view guideline",
                "TextView",1,2,7,7,null);

        // ready
        view[14] = new PropertyView();
        setUpView(view[14],"button",
                "View",1,8,4,10,null);
        // exit
        view[15] = new PropertyView();
        setUpView(view[15],"button",
                "View",4,8,7,10,null);

        return view;
    }
