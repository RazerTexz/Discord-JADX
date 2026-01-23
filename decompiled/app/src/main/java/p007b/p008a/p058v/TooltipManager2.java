package p007b.p008a.p058v;

import com.discord.tooltips.TooltipManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.v.e, reason: use source file name */
/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TooltipManager2 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ TooltipManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TooltipManager2(TooltipManager tooltipManager) {
        super(1);
        this.this$0 = tooltipManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        TooltipManager tooltipManager = this.this$0;
        Map<String, Integer> map = tooltipManager.tooltipNameToTooltipViewIdMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() != iIntValue) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        tooltipManager.tooltipNameToTooltipViewIdMap = Maps6.toMutableMap(linkedHashMap);
        return Unit.f27425a;
    }
}
