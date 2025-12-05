package com.discord.api.botuikit;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Component.kt */
/* renamed from: com.discord.api.botuikit.ComponentUtils, reason: use source file name */
/* loaded from: classes.dex */
public final class Component7 {
    public static final Component7 INSTANCE = new Component7();

    /* renamed from: a */
    public final int m7604a(List<? extends Component> list, int i, Function2<? super Integer, ? super Component, Unit> function2) {
        for (Component component : list) {
            Integer numValueOf = Integer.valueOf(i);
            i++;
            function2.invoke(numValueOf, component);
            if (component instanceof Component8) {
                i = m7604a(((Component8) component).mo7593a(), i, function2);
            }
        }
        return i;
    }
}
