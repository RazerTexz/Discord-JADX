package com.discord.widgets.bugreports;

import com.discord.models.domain.emoji.ModelEmojiCustom;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.SelectorBottomSheet2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetBugReport.kt */
/* loaded from: classes2.dex */
public final class WidgetBugReport$items$2 extends Lambda implements Function0<List<? extends SelectorBottomSheet2>> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$items$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends SelectorBottomSheet2> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends SelectorBottomSheet2> invoke2() {
        List<Priority> priorityLevels = WidgetBugReport.INSTANCE.getPriorityLevels();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(priorityLevels, 10));
        for (Priority priority : priorityLevels) {
            arrayList.add(new SelectorBottomSheet2(this.this$0.getString(priority.getTitle()), FormatUtils.m219k(this.this$0, priority.getDescription(), new Object[0], null, 4), null, ModelEmojiCustom.getImageUri(priority.getEmojiId(), true, 64), null, null, null, 116));
        }
        return arrayList;
    }
}
