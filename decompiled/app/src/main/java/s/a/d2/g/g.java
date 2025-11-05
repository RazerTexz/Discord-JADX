package s.a.d2.g;

import d0.z.d.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import s.a.a.r;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes3.dex */
public final class g extends o implements Function2<Integer, CoroutineContext.Element, Integer> {
    public final /* synthetic */ e $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(2);
        this.$this_checkContext = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer invoke(Integer num, CoroutineContext.Element element) {
        int iIntValue = num.intValue();
        CoroutineContext.Element element2 = element;
        CoroutineContext.Key<?> key = element2.getKey();
        CoroutineContext.Element element3 = this.$this_checkContext.collectContext.get(key);
        if (key != Job.INSTANCE) {
            iIntValue = element2 != element3 ? Integer.MIN_VALUE : iIntValue + 1;
        } else {
            Job job = (Job) element3;
            Job job2 = (Job) element2;
            while (true) {
                if (job2 != null) {
                    if (job2 == job || !(job2 instanceof r)) {
                        break;
                    }
                    job2 = (Job) ((r) job2).l.get(Job.INSTANCE);
                } else {
                    job2 = null;
                    break;
                }
            }
            if (job2 != job) {
                StringBuilder sb = new StringBuilder();
                sb.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n");
                sb.append("\t\tChild of ");
                sb.append(job2);
                sb.append(", expected child of ");
                sb.append(job);
                throw new IllegalStateException(b.d.b.a.a.K(sb, ".\n", "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n", "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
            if (job != null) {
            }
        }
        return Integer.valueOf(iIntValue);
    }
}
