package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p225i.p408d.ExclusionStrategy;
import p007b.p225i.p408d.FieldAttributes;
import p007b.p225i.p408d.FieldNamingStrategy;
import p007b.p225i.p408d.TypeAdapterFactory2;
import p007b.p225i.p408d.p409p.Since2;
import p007b.p225i.p408d.p409p.Until;
import p007b.p225i.p408d.p410q.C4922g;
import p007b.p225i.p408d.p410q.ObjectConstructor;
import p007b.p225i.p408d.p410q.p413y.ReflectionAccessor;

/* JADX INFO: loaded from: classes3.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory2 {

    /* JADX INFO: renamed from: j */
    public final C4922g f21527j;

    /* JADX INFO: renamed from: k */
    public final FieldNamingStrategy f21528k;

    /* JADX INFO: renamed from: l */
    public final Excluder f21529l;

    /* JADX INFO: renamed from: m */
    public final JsonAdapterAnnotationTypeAdapterFactory f21530m;

    /* JADX INFO: renamed from: n */
    public final ReflectionAccessor f21531n = ReflectionAccessor.f13148a;

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a */
        public final ObjectConstructor<T> f21532a;

        /* JADX INFO: renamed from: b */
        public final Map<String, AbstractC11109a> f21533b;

        public Adapter(ObjectConstructor<T> objectConstructor, Map<String, AbstractC11109a> map) {
            this.f21532a = objectConstructor;
            this.f21533b = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.mo6878N() == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            T tMo6869a = this.f21532a.mo6869a();
            try {
                jsonReader.mo6883b();
                while (jsonReader.mo6888q()) {
                    AbstractC11109a abstractC11109a = this.f21533b.get(jsonReader.mo6875C());
                    if (abstractC11109a == null || !abstractC11109a.f21536c) {
                        jsonReader.mo6879U();
                    } else {
                        abstractC11109a.mo6906a(jsonReader, tMo6869a);
                    }
                }
                jsonReader.mo6887f();
                return tMo6869a;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.mo6905s();
                return;
            }
            jsonWriter.mo6901c();
            try {
                for (AbstractC11109a abstractC11109a : this.f21533b.values()) {
                    if (abstractC11109a.mo6908c(t)) {
                        jsonWriter.mo6904n(abstractC11109a.f21534a);
                        abstractC11109a.mo6907b(jsonWriter, t);
                    }
                }
                jsonWriter.mo6903f();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$a */
    public static abstract class AbstractC11109a {

        /* JADX INFO: renamed from: a */
        public final String f21534a;

        /* JADX INFO: renamed from: b */
        public final boolean f21535b;

        /* JADX INFO: renamed from: c */
        public final boolean f21536c;

        public AbstractC11109a(String str, boolean z2, boolean z3) {
            this.f21534a = str;
            this.f21535b = z2;
            this.f21536c = z3;
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo6906a(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: b */
        public abstract void mo6907b(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException;

        /* JADX INFO: renamed from: c */
        public abstract boolean mo6908c(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(C4922g c4922g, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f21527j = c4922g;
        this.f21528k = fieldNamingStrategy;
        this.f21529l = excluder;
        this.f21530m = jsonAdapterAnnotationTypeAdapterFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m9233a(Field field, boolean z2) {
        boolean z3;
        Excluder excluder = this.f21529l;
        Class<?> type = field.getType();
        if (!(excluder.m9217b(type) || excluder.m9218f(type, z2))) {
            if ((excluder.f21485l & field.getModifiers()) == 0 && ((excluder.f21484k == -1.0d || excluder.m9221i((Since2) field.getAnnotation(Since2.class), (Until) field.getAnnotation(Until.class))) && !field.isSynthetic() && ((excluder.f21486m || !excluder.m9220h(field.getType())) && !excluder.m9219g(field.getType())))) {
                List<ExclusionStrategy> list = z2 ? excluder.f21487n : excluder.f21488o;
                if (!list.isEmpty()) {
                    FieldAttributes fieldAttributes = new FieldAttributes(field);
                    Iterator<ExclusionStrategy> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().m6846a(fieldAttributes)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    return true;
                }
            } else {
                z3 = true;
                if (z3) {
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:43)
        */
    @Override // p007b.p225i.p408d.TypeAdapterFactory2
    public <T> com.google.gson.TypeAdapter<T> create(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r36v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(jadx.core.dex.instructions.args.InsnArg)" because "resultArg" is null
        	at jadx.core.dex.visitors.MoveInlineVisitor.processMove(MoveInlineVisitor.java:52)
        	at jadx.core.dex.visitors.MoveInlineVisitor.moveInline(MoveInlineVisitor.java:41)
        */
}
