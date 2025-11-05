package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$onClickListener$1 extends o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
    public static final WidgetGlobalSearchGuildsAdapter$onClickListener$1 INSTANCE = new WidgetGlobalSearchGuildsAdapter$onClickListener$1();

    public WidgetGlobalSearchGuildsAdapter$onClickListener$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
        invoke(num.intValue(), num2.intValue(), item);
        return Unit.a;
    }

    public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
        m.checkNotNullParameter(item, "<anonymous parameter 2>");
    }
}
