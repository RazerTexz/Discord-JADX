package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubDescription.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubDescription$selectorArgs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubDescription6 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription6(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends WidgetRadioSelectorBottomSheet2> invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        return invoke2(widgetHubDescriptionViewModel3);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<WidgetRadioSelectorBottomSheet2> invoke2(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "state");
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = widgetHubDescriptionViewModel3.getChannel();
        List<DirectoryEntryCategory> categories = companion.getCategories(channel != null && ChannelUtils.m7700x(channel));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(categories, 10));
        for (DirectoryEntryCategory directoryEntryCategory : categories) {
            int key = directoryEntryCategory.getKey();
            DirectoryEntryCategory category = this.this$0.getViewModel().getCategory();
            arrayList.add(new WidgetRadioSelectorBottomSheet2(key, directoryEntryCategory.getTitle(this.this$0.requireContext()), category != null && category.getKey() == directoryEntryCategory.getKey()));
        }
        return arrayList;
    }
}
