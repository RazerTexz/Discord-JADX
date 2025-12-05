package p007b.p109f.p161j.p181p;

import android.os.SystemClock;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;
import p007b.p109f.p115d.p122g.ByteArrayPool;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteBufferOutputStream;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p007b.p109f.p161j.p175j.EncodedImageOrigin;
import p007b.p109f.p161j.p181p.HttpUrlConnectionNetworkFetcher;
import p007b.p109f.p161j.p181p.NetworkFetcher2;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: NetworkFetchProducer.java */
/* renamed from: b.f.j.p.n0, reason: use source file name */
/* loaded from: classes3.dex */
public class NetworkFetchProducer implements Producer2<EncodedImage2> {

    /* renamed from: a */
    public final PooledByteBufferFactory f4169a;

    /* renamed from: b */
    public final ByteArrayPool f4170b;

    /* renamed from: c */
    public final NetworkFetcher2 f4171c;

    /* compiled from: NetworkFetchProducer.java */
    /* renamed from: b.f.j.p.n0$a */
    public class a implements NetworkFetcher2.a {

        /* renamed from: a */
        public final /* synthetic */ FetchState2 f4172a;

        public a(FetchState2 fetchState2) {
            this.f4172a = fetchState2;
        }

        /* renamed from: a */
        public void m1508a(Throwable th) {
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = this.f4172a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState2.m1524a().mo1364k(fetchState2.f4259b, "NetworkFetchProducer", th, null);
            fetchState2.m1524a().mo1356c(fetchState2.f4259b, "NetworkFetchProducer", false);
            fetchState2.f4259b.mo1456n("network");
            fetchState2.f4258a.mo1425c(th);
        }

        /* renamed from: b */
        public void m1509b(InputStream inputStream, int i) throws Throwable {
            FrescoSystrace.m1527b();
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = this.f4172a;
            PooledByteBufferOutputStream pooledByteBufferOutputStreamMo997e = i > 0 ? networkFetchProducer.f4169a.mo997e(i) : networkFetchProducer.f4169a.mo993a();
            byte[] bArr = networkFetchProducer.f4170b.get(16384);
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        NetworkFetcher2 networkFetcher2 = networkFetchProducer.f4171c;
                        int i3 = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamMo997e).f19562l;
                        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = (HttpUrlConnectionNetworkFetcher) networkFetcher2;
                        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
                        ((HttpUrlConnectionNetworkFetcher.a) fetchState2).f3992f = httpUrlConnectionNetworkFetcher.f3989c.now();
                        networkFetchProducer.m1506c(pooledByteBufferOutputStreamMo997e, fetchState2);
                        networkFetchProducer.f4170b.release(bArr);
                        pooledByteBufferOutputStreamMo997e.close();
                        FrescoSystrace.m1527b();
                        return;
                    }
                    if (i2 > 0) {
                        pooledByteBufferOutputStreamMo997e.write(bArr, 0, i2);
                        networkFetchProducer.m1507d(pooledByteBufferOutputStreamMo997e, fetchState2);
                        fetchState2.f4258a.mo1423a(i > 0 ? ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStreamMo997e).f19562l / i : 1.0f - ((float) Math.exp((-r4) / 50000.0d)));
                    }
                } catch (Throwable th) {
                    networkFetchProducer.f4170b.release(bArr);
                    pooledByteBufferOutputStreamMo997e.close();
                    throw th;
                }
            }
        }
    }

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher2 networkFetcher2) {
        this.f4169a = pooledByteBufferFactory;
        this.f4170b = byteArrayPool;
        this.f4171c = networkFetcher2;
    }

    /* renamed from: e */
    public static void m1505e(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i, BytesRange bytesRange, Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) throws Throwable {
        CloseableReference closeableReferenceM8632A = CloseableReference.m8632A(((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).m8707b());
        EncodedImage2 encodedImage2 = null;
        try {
            EncodedImage2 encodedImage22 = new EncodedImage2(closeableReferenceM8632A);
            try {
                encodedImage22.f3900s = null;
                encodedImage22.m1345q();
                producerContext.mo1450h(EncodedImageOrigin.NETWORK);
                consumer2.mo1424b(encodedImage22, i);
                encodedImage22.close();
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
            } catch (Throwable th) {
                th = th;
                encodedImage2 = encodedImage22;
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
                if (closeableReferenceM8632A != null) {
                    closeableReferenceM8632A.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* renamed from: b */
    public void mo1417b(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
        producerContext.mo1457o().mo1358e(producerContext, "NetworkFetchProducer");
        Objects.requireNonNull((HttpUrlConnectionNetworkFetcher) this.f4171c);
        HttpUrlConnectionNetworkFetcher.a aVar = new HttpUrlConnectionNetworkFetcher.a(consumer2, producerContext);
        NetworkFetcher2 networkFetcher2 = this.f4171c;
        a aVar2 = new a(aVar);
        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = (HttpUrlConnectionNetworkFetcher) networkFetcher2;
        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
        aVar.f3990d = httpUrlConnectionNetworkFetcher.f3989c.now();
        producerContext.mo1448f(new HttpUrlConnectionNetworkFetcher3(httpUrlConnectionNetworkFetcher, httpUrlConnectionNetworkFetcher.f3988b.submit(new HttpUrlConnectionNetworkFetcher2(httpUrlConnectionNetworkFetcher, aVar, aVar2)), aVar2));
    }

    /* renamed from: c */
    public void m1506c(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState2 fetchState2) throws Throwable {
        HashMap map;
        int i = ((MemoryPooledByteBufferOutputStream) pooledByteBufferOutputStream).f19562l;
        if (fetchState2.m1524a().mo1360g(fetchState2.f4259b, "NetworkFetchProducer")) {
            Objects.requireNonNull((HttpUrlConnectionNetworkFetcher) this.f4171c);
            HttpUrlConnectionNetworkFetcher.a aVar = (HttpUrlConnectionNetworkFetcher.a) fetchState2;
            map = new HashMap(4);
            map.put("queue_time", Long.toString(aVar.f3991e - aVar.f3990d));
            map.put("fetch_time", Long.toString(aVar.f3992f - aVar.f3991e));
            map.put("total_time", Long.toString(aVar.f3992f - aVar.f3990d));
            map.put("image_size", Integer.toString(i));
        } else {
            map = null;
        }
        ProducerListener2 producerListener2M1524a = fetchState2.m1524a();
        producerListener2M1524a.mo1363j(fetchState2.f4259b, "NetworkFetchProducer", map);
        producerListener2M1524a.mo1356c(fetchState2.f4259b, "NetworkFetchProducer", true);
        fetchState2.f4259b.mo1456n("network");
        m1505e(pooledByteBufferOutputStream, 1, null, fetchState2.f4258a, fetchState2.f4259b);
    }

    /* renamed from: d */
    public void m1507d(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState2 fetchState2) throws Throwable {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (fetchState2.f4259b.mo1458p()) {
            Objects.requireNonNull(this.f4171c);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || jUptimeMillis - fetchState2.f4260c < 100) {
            return;
        }
        fetchState2.f4260c = jUptimeMillis;
        fetchState2.m1524a().mo1354a(fetchState2.f4259b, "NetworkFetchProducer", "intermediate_result");
        m1505e(pooledByteBufferOutputStream, 0, null, fetchState2.f4258a, fetchState2.f4259b);
    }
}
