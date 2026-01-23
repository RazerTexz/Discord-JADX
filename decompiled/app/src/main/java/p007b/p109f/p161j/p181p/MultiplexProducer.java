package p007b.p109f.p161j.p181p;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p127l.TriState;
import p007b.p109f.p161j.p169d.Priority2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.p.l0, reason: use source file name */
/* JADX INFO: compiled from: MultiplexProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer2<T> {

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public final Map<K, MultiplexProducer<K, T>.b> f4127a;

    /* JADX INFO: renamed from: b */
    public final Producer2<T> f4128b;

    /* JADX INFO: renamed from: c */
    public final boolean f4129c;

    /* JADX INFO: renamed from: d */
    public final String f4130d;

    /* JADX INFO: renamed from: e */
    public final String f4131e;

    /* JADX INFO: renamed from: b.f.j.p.l0$b */
    /* JADX INFO: compiled from: MultiplexProducer.java */
    @VisibleForTesting
    public class b {

        /* JADX INFO: renamed from: a */
        public final K f4132a;

        /* JADX INFO: renamed from: b */
        public final CopyOnWriteArraySet<Pair<Consumer2<T>, ProducerContext>> f4133b = new CopyOnWriteArraySet<>();

        /* JADX INFO: renamed from: c */
        public T f4134c;

        /* JADX INFO: renamed from: d */
        public float f4135d;

        /* JADX INFO: renamed from: e */
        public int f4136e;

        /* JADX INFO: renamed from: f */
        public BaseProducerContext f4137f;

        /* JADX INFO: renamed from: g */
        public MultiplexProducer<K, T>.b.a f4138g;

        /* JADX INFO: renamed from: b.f.j.p.l0$b$a */
        /* JADX INFO: compiled from: MultiplexProducer.java */
        public class a extends BaseConsumer<T> {
            public a(a aVar) {
            }

            @Override // p007b.p109f.p161j.p181p.BaseConsumer
            /* JADX INFO: renamed from: g */
            public void mo1318g() {
                try {
                    FrescoSystrace.m1527b();
                    b bVar = b.this;
                    synchronized (bVar) {
                        if (bVar.f4138g == this) {
                            bVar.f4138g = null;
                            bVar.f4137f = null;
                            bVar.m1484b(bVar.f4134c);
                            bVar.f4134c = null;
                            bVar.m1491i(TriState.UNSET);
                        }
                    }
                } finally {
                    FrescoSystrace.m1527b();
                }
            }

            @Override // p007b.p109f.p161j.p181p.BaseConsumer
            /* JADX INFO: renamed from: h */
            public void mo1319h(Throwable th) {
                try {
                    FrescoSystrace.m1527b();
                    b.this.m1488f(this, th);
                } finally {
                    FrescoSystrace.m1527b();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p007b.p109f.p161j.p181p.BaseConsumer
            /* JADX INFO: renamed from: i */
            public void mo1320i(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    FrescoSystrace.m1527b();
                    b.this.m1489g(this, closeable, i);
                } finally {
                    FrescoSystrace.m1527b();
                }
            }

            @Override // p007b.p109f.p161j.p181p.BaseConsumer
            /* JADX INFO: renamed from: j */
            public void mo1321j(float f) {
                try {
                    FrescoSystrace.m1527b();
                    b.this.m1490h(this, f);
                } finally {
                    FrescoSystrace.m1527b();
                }
            }
        }

        public b(K k) {
            this.f4132a = k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public boolean m1483a(Consumer2<T> consumer2, ProducerContext producerContext) {
            MultiplexProducer<K, T>.b bVar;
            Pair<Consumer2<T>, ProducerContext> pairCreate = Pair.create(consumer2, producerContext);
            synchronized (this) {
                MultiplexProducer multiplexProducer = MultiplexProducer.this;
                K k = this.f4132a;
                synchronized (multiplexProducer) {
                    bVar = multiplexProducer.f4127a.get(k);
                }
                if (bVar != this) {
                    return false;
                }
                this.f4133b.add(pairCreate);
                List<ProducerContextCallbacks> listM1493k = m1493k();
                List<ProducerContextCallbacks> listM1494l = m1494l();
                List<ProducerContextCallbacks> listM1492j = m1492j();
                Closeable closeableMo1476c = this.f4134c;
                float f = this.f4135d;
                int i = this.f4136e;
                BaseProducerContext.m1441s(listM1493k);
                BaseProducerContext.m1442t(listM1494l);
                BaseProducerContext.m1440r(listM1492j);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableMo1476c != this.f4134c) {
                            closeableMo1476c = null;
                        } else if (closeableMo1476c != null) {
                            closeableMo1476c = MultiplexProducer.this.mo1476c(closeableMo1476c);
                        }
                    }
                    if (closeableMo1476c != null) {
                        if (f > 0.0f) {
                            consumer2.mo1423a(f);
                        }
                        consumer2.mo1424b(closeableMo1476c, i);
                        m1484b(closeableMo1476c);
                    }
                }
                producerContext.mo1448f(new MultiplexProducer2(this, pairCreate));
                return true;
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m1484b(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public final synchronized boolean m1485c() {
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) it.next().second).mo1458p()) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: d */
        public final synchronized boolean m1486d() {
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) it.next().second).mo1453k()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: renamed from: e */
        public final synchronized Priority2 m1487e() {
            Priority2 priority2;
            priority2 = Priority2.LOW;
            Iterator<Pair<Consumer2<T>, ProducerContext>> it = this.f4133b.iterator();
            while (it.hasNext()) {
                Priority2 priority2Mo1445c = ((ProducerContext) it.next().second).mo1445c();
                if (priority2.ordinal() <= priority2Mo1445c.ordinal()) {
                    priority2 = priority2Mo1445c;
                }
            }
            return priority2;
        }

        /* JADX INFO: renamed from: f */
        public void m1488f(MultiplexProducer<K, T>.b.a aVar, Throwable th) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                this.f4133b.clear();
                MultiplexProducer.this.m1482e(this.f4132a, this);
                m1484b(this.f4134c);
                this.f4134c = null;
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f4133b) {
                    synchronized (pair) {
                        ((ProducerContext) pair.second).mo1457o().mo1364k((ProducerContext) pair.second, MultiplexProducer.this.f4130d, th, null);
                        ((Consumer2) pair.first).mo1425c(th);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: g */
        public void m1489g(MultiplexProducer<K, T>.b.a aVar, T t, int i) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                m1484b(this.f4134c);
                this.f4134c = null;
                int size = this.f4133b.size();
                if (BaseConsumer.m1420f(i)) {
                    this.f4134c = (T) MultiplexProducer.this.mo1476c(t);
                    this.f4136e = i;
                } else {
                    this.f4133b.clear();
                    MultiplexProducer.this.m1482e(this.f4132a, this);
                }
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f4133b) {
                    synchronized (pair) {
                        if (BaseConsumer.m1419e(i)) {
                            ((ProducerContext) pair.second).mo1457o().mo1363j((ProducerContext) pair.second, MultiplexProducer.this.f4130d, null);
                            BaseProducerContext baseProducerContext = this.f4137f;
                            if (baseProducerContext != null) {
                                ((ProducerContext) pair.second).mo1452j(baseProducerContext.f4032h);
                            }
                            ((ProducerContext) pair.second).mo1446d(MultiplexProducer.this.f4131e, Integer.valueOf(size));
                        }
                        ((Consumer2) pair.first).mo1424b(t, i);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: h */
        public void m1490h(MultiplexProducer<K, T>.b.a aVar, float f) {
            synchronized (this) {
                if (this.f4138g != aVar) {
                    return;
                }
                this.f4135d = f;
                for (Pair<Consumer2<T>, ProducerContext> pair : this.f4133b) {
                    synchronized (pair) {
                        ((Consumer2) pair.first).mo1423a(f);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: i */
        public final void m1491i(TriState triState) {
            synchronized (this) {
                boolean z2 = true;
                AnimatableValueParser.m527i(Boolean.valueOf(this.f4137f == null));
                AnimatableValueParser.m527i(Boolean.valueOf(this.f4138g == null));
                if (this.f4133b.isEmpty()) {
                    MultiplexProducer.this.m1482e(this.f4132a, this);
                    return;
                }
                ProducerContext producerContext = (ProducerContext) this.f4133b.iterator().next().second;
                BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.mo1447e(), producerContext.getId(), null, producerContext.mo1457o(), producerContext.mo1444b(), producerContext.mo1459q(), m1486d(), m1485c(), m1487e(), producerContext.mo1449g());
                this.f4137f = baseProducerContext;
                baseProducerContext.mo1452j(producerContext.mo1443a());
                Objects.requireNonNull(triState);
                if (triState != TriState.UNSET) {
                    BaseProducerContext baseProducerContext2 = this.f4137f;
                    int iOrdinal = triState.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            if (iOrdinal == 2) {
                                throw new IllegalStateException("No boolean equivalent for UNSET");
                            }
                            throw new IllegalStateException("Unrecognized TriState value: " + triState);
                        }
                        z2 = false;
                    }
                    baseProducerContext2.mo1446d("started_as_prefetch", Boolean.valueOf(z2));
                }
                MultiplexProducer<K, T>.b.a aVar = new a(null);
                this.f4138g = aVar;
                MultiplexProducer.this.f4128b.mo1417b(aVar, this.f4137f);
            }
        }

        /* JADX INFO: renamed from: j */
        public final synchronized List<ProducerContextCallbacks> m1492j() {
            BaseProducerContext baseProducerContext = this.f4137f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zM1485c = m1485c();
            synchronized (baseProducerContext) {
                if (zM1485c != baseProducerContext.f4035k) {
                    baseProducerContext.f4035k = zM1485c;
                    arrayList = new ArrayList(baseProducerContext.f4037m);
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: k */
        public final synchronized List<ProducerContextCallbacks> m1493k() {
            BaseProducerContext baseProducerContext = this.f4137f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zM1486d = m1486d();
            synchronized (baseProducerContext) {
                if (zM1486d != baseProducerContext.f4033i) {
                    baseProducerContext.f4033i = zM1486d;
                    arrayList = new ArrayList(baseProducerContext.f4037m);
                }
            }
            return arrayList;
        }

        /* JADX INFO: renamed from: l */
        public final synchronized List<ProducerContextCallbacks> m1494l() {
            BaseProducerContext baseProducerContext = this.f4137f;
            if (baseProducerContext == null) {
                return null;
            }
            return baseProducerContext.m1461v(m1487e());
        }
    }

    public MultiplexProducer(Producer2<T> producer2, String str, String str2) {
        this.f4128b = producer2;
        this.f4127a = new HashMap();
        this.f4129c = false;
        this.f4130d = str;
        this.f4131e = str2;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<T> consumer2, ProducerContext producerContext) {
        boolean z2;
        MultiplexProducer<K, T>.b bVar;
        try {
            FrescoSystrace.m1527b();
            producerContext.mo1457o().mo1358e(producerContext, this.f4130d);
            K kMo1477d = mo1477d(producerContext);
            do {
                z2 = false;
                synchronized (this) {
                    synchronized (this) {
                        bVar = this.f4127a.get(kMo1477d);
                    }
                }
                if (bVar == null) {
                    synchronized (this) {
                        bVar = new b(kMo1477d);
                        this.f4127a.put(kMo1477d, bVar);
                        z2 = true;
                    }
                }
            } while (!bVar.m1483a(consumer2, producerContext));
            if (z2) {
                bVar.m1491i(TriState.m1004f(producerContext.mo1453k()));
            }
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract T mo1476c(T t);

    /* JADX INFO: renamed from: d */
    public abstract K mo1477d(ProducerContext producerContext);

    /* JADX INFO: renamed from: e */
    public synchronized void m1482e(K k, MultiplexProducer<K, T>.b bVar) {
        if (this.f4127a.get(k) == bVar) {
            this.f4127a.remove(k);
        }
    }

    public MultiplexProducer(Producer2<T> producer2, String str, String str2, boolean z2) {
        this.f4128b = producer2;
        this.f4127a = new HashMap();
        this.f4129c = z2;
        this.f4130d = str;
        this.f4131e = str2;
    }
}
