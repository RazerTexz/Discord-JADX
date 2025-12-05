package p007b.p195g.p196a.p198b;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p198b.p200p.CharacterEscapes;
import p007b.p195g.p196a.p198b.p200p.InputDecorator;
import p007b.p195g.p196a.p198b.p200p.OutputDecorator;
import p007b.p195g.p196a.p198b.p202r.ByteQuadsCanonicalizer;
import p007b.p195g.p196a.p198b.p202r.CharsToNameCanonicalizer;
import p007b.p195g.p196a.p198b.p204t.BufferRecycler;
import p007b.p195g.p196a.p198b.p204t.BufferRecyclers;
import p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter;
import p007b.p195g.p196a.p198b.p204t.JacksonFeature;
import p007b.p195g.p196a.p198b.p204t.ThreadLocalBufferManager;

/* compiled from: JsonFactory.java */
/* renamed from: b.g.a.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public class JsonFactory extends TokenStreamFactory implements Serializable {

    /* renamed from: j */
    public static final int f4455j = a.m1628h();

    /* renamed from: k */
    public static final int f4456k = JsonParser.a.m1672f();

    /* renamed from: l */
    public static final int f4457l = JsonGenerator.a.m1667f();

    /* renamed from: m */
    public static final SerializableString f4458m = DefaultPrettyPrinter.f4599j;
    private static final long serialVersionUID = 2;
    public CharacterEscapes _characterEscapes;
    public int _factoryFeatures;
    public int _generatorFeatures;
    public InputDecorator _inputDecorator;
    public int _maximumNonEscapedChar;
    public ObjectCodec _objectCodec;
    public OutputDecorator _outputDecorator;
    public int _parserFeatures;
    public final char _quoteChar;
    public SerializableString _rootValueSeparator;

    /* compiled from: JsonFactory.java */
    /* renamed from: b.g.a.b.c$a */
    public enum a implements JacksonFeature {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true),
        USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING(true);

        private final boolean _defaultState;

        a(boolean z2) {
            this._defaultState = z2;
        }

        /* renamed from: h */
        public static int m1628h() {
            a[] aVarArrValues = values();
            int iMo1630g = 0;
            for (int i = 0; i < 4; i++) {
                a aVar = aVarArrValues[i];
                if (aVar._defaultState) {
                    iMo1630g |= aVar.mo1630g();
                }
            }
            return iMo1630g;
        }

        @Override // p007b.p195g.p196a.p198b.p204t.JacksonFeature
        /* renamed from: f */
        public boolean mo1629f() {
            return this._defaultState;
        }

        @Override // p007b.p195g.p196a.p198b.p204t.JacksonFeature
        /* renamed from: g */
        public int mo1630g() {
            return 1 << ordinal();
        }
    }

    public JsonFactory() {
        this(null);
    }

    /* renamed from: a */
    public BufferRecycler m1626a() {
        SoftReference<BufferRecycler> softReference;
        if (!((a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.mo1630g() & this._factoryFeatures) != 0)) {
            return new BufferRecycler();
        }
        SoftReference<BufferRecycler> softReference2 = BufferRecyclers.f4596b.get();
        BufferRecycler bufferRecycler = softReference2 == null ? null : softReference2.get();
        if (bufferRecycler == null) {
            bufferRecycler = new BufferRecycler();
            ThreadLocalBufferManager threadLocalBufferManager = BufferRecyclers.f4595a;
            if (threadLocalBufferManager != null) {
                softReference = new SoftReference<>(bufferRecycler, threadLocalBufferManager.f4615b);
                threadLocalBufferManager.f4614a.put(softReference, Boolean.TRUE);
                while (true) {
                    SoftReference softReference3 = (SoftReference) threadLocalBufferManager.f4615b.poll();
                    if (softReference3 == null) {
                        break;
                    }
                    threadLocalBufferManager.f4614a.remove(softReference3);
                }
            } else {
                softReference = new SoftReference<>(bufferRecycler);
            }
            BufferRecyclers.f4596b.set(softReference);
        }
        return bufferRecycler;
    }

    /* renamed from: b */
    public ObjectCodec mo1627b() {
        return this._objectCodec;
    }

    public Object readResolve() {
        return new JsonFactory(this, this._objectCodec);
    }

    public JsonFactory(ObjectCodec objectCodec) {
        CharsToNameCanonicalizer.m1726a();
        ByteQuadsCanonicalizer.m1725a();
        this._factoryFeatures = f4455j;
        this._parserFeatures = f4456k;
        this._generatorFeatures = f4457l;
        this._rootValueSeparator = f4458m;
        this._objectCodec = objectCodec;
        this._quoteChar = '\"';
    }

    public JsonFactory(JsonFactory jsonFactory, ObjectCodec objectCodec) {
        CharsToNameCanonicalizer.m1726a();
        ByteQuadsCanonicalizer.m1725a();
        this._factoryFeatures = f4455j;
        this._parserFeatures = f4456k;
        this._generatorFeatures = f4457l;
        this._rootValueSeparator = f4458m;
        this._objectCodec = objectCodec;
        this._factoryFeatures = jsonFactory._factoryFeatures;
        this._parserFeatures = jsonFactory._parserFeatures;
        this._generatorFeatures = jsonFactory._generatorFeatures;
        this._rootValueSeparator = jsonFactory._rootValueSeparator;
        this._maximumNonEscapedChar = jsonFactory._maximumNonEscapedChar;
        this._quoteChar = jsonFactory._quoteChar;
    }
}
