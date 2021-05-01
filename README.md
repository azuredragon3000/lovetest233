PropertyView[] view;
    int x,y;

    ObjectParentViewSpec(Point size){
        x = size.x;
        y = size.y;
        view = getPropertyView();
    }

    public PropertyView[] getView() {
        return view;
    }
    abstract PropertyView[] getPropertyView();

    Rect getRect(int l, int t, int r, int b) {
        int temp_l,temp_t,temp_r,temp_b;

        temp_l = (l*x)/10;
        temp_t = (t*y)/10;
        temp_r = (r*x)/10;
        temp_b = (b*y)/10;
        Rect Rtemp = new Rect(temp_l,temp_t,temp_r,temp_b);

        return Rtemp;
    }

    void setUpView(PropertyView propertyView, String background, String view, int i1, int i2, int i3, int i4, String question) {
        Rect Rtemp;
        propertyView.bg = background;
        propertyView.typeView = view;
        Rtemp = getRect(i1,i2,i3,i4);
        propertyView.position = new Rect(Rtemp);
        propertyView.question = question;
    }
