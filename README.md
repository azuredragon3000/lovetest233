 private Point size;
    private ArrayList<ObjectView> mObjectView;
    private MFactoryView mFactoryMView;
    private ArrayList<InputObserver> inputObservers = new ArrayList();
    private InputViewStart inputViewStart;
    private InputView1 mInputv1;
    private InputView2 mInputv2;
    private InputView3 mInputv3;

    private int stage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        size = MDisplay.getDisplay(this);
        mFactoryMView = new MFactoryView(this,size);

        inputViewStart = new InputViewStart(this,this);
        mInputv1 = new InputView1(this,this,this);
        mInputv2 = new InputView2(this,this);
        mInputv3 = new InputView3(this,this);

        Question question = getQuestion();
        mObjectView = new ArrayList<>();
        mObjectView.add(0,mFactoryMView.create(new ObjectViewStartSpec(size), inputViewStart,question));
        mObjectView.add(1,mFactoryMView.create(new ObjectView1Spec(size),mInputv1,question));
        mObjectView.add(2,mFactoryMView.create(new ObjectView2Spec(size),mInputv2,question));
        mObjectView.add(3,mFactoryMView.create(new ObjectView3Spec(size),mInputv3,question));
        setViewStart();
    }

    @Override
    public Question PerlQuestion() {
        Question question = new Question();

        question.Question = "Perl";
        question.A ="A";
        question.B ="B";
        question.C ="C";
        question.D ="D";

        return question;
    }

    @Override
    public Question JavaQuestion() {
        Question question = new Question();
        question.Question = "Java";
        question.A ="A";
        question.B ="B";
        question.C ="C";
        question.D ="D";
        return question;
    }

    @Override
    public void setViewStart() {
        int stage = Constants.VIEWSTART;
        this.stage = stage;
        setContentView(mObjectView.get(0).mLayout);
    }

    @Override
    public void setView1() {
        int stage = Constants.VIEW1;
        this.stage = stage;

        setContentView(mObjectView.get(1).mLayout);
    }

    @Override
    public void setView2() {
        int stage = Constants.VIEW2;
        this.stage = stage;
        if(mObjectView.get(3).getTag().equals("Java")) {
            mObjectView.get(2).setQuestion(JavaQuestion());
        }else if(mObjectView.get(3).getTag().equals("Perl")){
            mObjectView.get(2).setQuestion(PerlQuestion());
        }
        setContentView(mObjectView.get(2).mLayout);
    }

    @Override
    public void setView3(String question) {
        int stage = Constants.VIEW3;
        this.stage = stage;
        mObjectView.get(3).setTag(question);
        setContentView(mObjectView.get(3).mLayout);
    }

    public void addObserver(InputObserver o) {
        inputObservers.add(o);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        for (InputObserver o : inputObservers) {
            o.handleInput(motionEvent,stage);
        }
        return true;
    }

    private Question getQuestion() {
        Question question = new Question();

        question.Question = "begin question";
        question.A = "A";
        question.B = "B";
        question.C = "C";
        question.D = "D";

        return question;
    }
