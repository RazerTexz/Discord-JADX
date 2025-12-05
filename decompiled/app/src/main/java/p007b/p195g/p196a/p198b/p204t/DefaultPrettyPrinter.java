package p007b.p195g.p196a.p198b.p204t;

import java.io.IOException;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.PrettyPrinter2;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p200p.SerializedString;

/* compiled from: DefaultPrettyPrinter.java */
/* renamed from: b.g.a.b.t.d, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultPrettyPrinter implements PrettyPrinter2, Instantiatable<DefaultPrettyPrinter>, Serializable {

    /* renamed from: j */
    public static final SerializedString f4599j = new SerializedString(" ");
    private static final long serialVersionUID = 1;
    public b _arrayIndenter;
    public String _objectFieldValueSeparatorWithSpaces;
    public b _objectIndenter;
    public final SerializableString _rootSeparator;
    public Separators _separators;
    public boolean _spacesInObjectEntries;

    /* renamed from: k */
    public transient int f4600k;

    /* compiled from: DefaultPrettyPrinter.java */
    /* renamed from: b.g.a.b.t.d$a */
    public static class a extends c {

        /* renamed from: j */
        public static final a f4601j = new a();

        @Override // p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter.b
        /* renamed from: a */
        public void mo1731a(JsonGenerator jsonGenerator, int i) throws IOException {
            jsonGenerator.mo1640R(' ');
        }

        @Override // p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter.c, p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter.b
        public boolean isInline() {
            return true;
        }
    }

    /* compiled from: DefaultPrettyPrinter.java */
    /* renamed from: b.g.a.b.t.d$b */
    public interface b {
        /* renamed from: a */
        void mo1731a(JsonGenerator jsonGenerator, int i) throws IOException;

        boolean isInline();
    }

    /* compiled from: DefaultPrettyPrinter.java */
    /* renamed from: b.g.a.b.t.d$c */
    public static class c implements b, Serializable {
        @Override // p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter.b
        public boolean isInline() {
            return !(this instanceof DefaultIndenter);
        }
    }

    public DefaultPrettyPrinter() {
        SerializedString serializedString = f4599j;
        this._arrayIndenter = a.f4601j;
        this._objectIndenter = DefaultIndenter.f4598k;
        this._spacesInObjectEntries = true;
        this._rootSeparator = serializedString;
        Separators separators = PrettyPrinter2.f4519b;
        this._separators = separators;
        StringBuilder sbM833U = outline.m833U(" ");
        sbM833U.append(separators.m1738c());
        sbM833U.append(" ");
        this._objectFieldValueSeparatorWithSpaces = sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: a */
    public void mo1678a(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo1640R('{');
        if (this._objectIndenter.isInline()) {
            return;
        }
        this.f4600k++;
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: b */
    public void mo1679b(JsonGenerator jsonGenerator) throws IOException {
        SerializableString serializableString = this._rootSeparator;
        if (serializableString != null) {
            jsonGenerator.mo1641S(serializableString);
        }
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: c */
    public void mo1680c(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo1640R(this._separators.m1736a());
        this._arrayIndenter.mo1731a(jsonGenerator, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: d */
    public void mo1681d(JsonGenerator jsonGenerator) throws IOException {
        this._objectIndenter.mo1731a(jsonGenerator, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.p204t.Instantiatable
    /* renamed from: e */
    public DefaultPrettyPrinter mo1732e() {
        if (DefaultPrettyPrinter.class == DefaultPrettyPrinter.class) {
            return new DefaultPrettyPrinter(this);
        }
        throw new IllegalStateException(outline.m867o(DefaultPrettyPrinter.class, outline.m833U("Failed `createInstance()`: "), " does not override method; it has to"));
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: f */
    public void mo1682f(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this._objectIndenter.isInline()) {
            this.f4600k--;
        }
        if (i > 0) {
            this._objectIndenter.mo1731a(jsonGenerator, this.f4600k);
        } else {
            jsonGenerator.mo1640R(' ');
        }
        jsonGenerator.mo1640R('}');
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: g */
    public void mo1683g(JsonGenerator jsonGenerator) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.f4600k++;
        }
        jsonGenerator.mo1640R('[');
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: h */
    public void mo1684h(JsonGenerator jsonGenerator) throws IOException {
        this._arrayIndenter.mo1731a(jsonGenerator, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: i */
    public void mo1685i(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.mo1640R(this._separators.m1737b());
        this._objectIndenter.mo1731a(jsonGenerator, this.f4600k);
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: j */
    public void mo1686j(JsonGenerator jsonGenerator, int i) throws IOException {
        if (!this._arrayIndenter.isInline()) {
            this.f4600k--;
        }
        if (i > 0) {
            this._arrayIndenter.mo1731a(jsonGenerator, this.f4600k);
        } else {
            jsonGenerator.mo1640R(' ');
        }
        jsonGenerator.mo1640R(']');
    }

    @Override // p007b.p195g.p196a.p198b.PrettyPrinter2
    /* renamed from: k */
    public void mo1687k(JsonGenerator jsonGenerator) throws IOException {
        if (this._spacesInObjectEntries) {
            jsonGenerator.mo1642T(this._objectFieldValueSeparatorWithSpaces);
        } else {
            jsonGenerator.mo1640R(this._separators.m1738c());
        }
    }

    public DefaultPrettyPrinter(DefaultPrettyPrinter defaultPrettyPrinter) {
        SerializableString serializableString = defaultPrettyPrinter._rootSeparator;
        this._arrayIndenter = a.f4601j;
        this._objectIndenter = DefaultIndenter.f4598k;
        this._spacesInObjectEntries = true;
        this._arrayIndenter = defaultPrettyPrinter._arrayIndenter;
        this._objectIndenter = defaultPrettyPrinter._objectIndenter;
        this._spacesInObjectEntries = defaultPrettyPrinter._spacesInObjectEntries;
        this.f4600k = defaultPrettyPrinter.f4600k;
        this._separators = defaultPrettyPrinter._separators;
        this._objectFieldValueSeparatorWithSpaces = defaultPrettyPrinter._objectFieldValueSeparatorWithSpaces;
        this._rootSeparator = serializableString;
    }
}
