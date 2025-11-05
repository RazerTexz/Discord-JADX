package com.discord.widgets.settings.developer;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.experiments.ExperimentRegistry2;
import com.discord.widgets.settings.developer.ExperimentOverridesAdapter;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsDeveloper.kt */
/* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper3 implements ExperimentOverridesAdapter.Item {
    public final /* synthetic */ Map $allOverrides$inlined;
    public final /* synthetic */ ExperimentRegistry2 $registeredExperiment;
    private final String apiName;
    private final List<String> bucketDescriptions;
    private final String name;
    private final Integer overrideBucket;
    public final /* synthetic */ WidgetSettingsDeveloper.AnonymousClass1 this$0;
    private final Function1<Integer, Unit> onOverrideBucketSelected = new AnonymousClass1();
    private final Function0<Unit> onOverrideBucketCleared = new AnonymousClass2();

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetSettingsDeveloper3 widgetSettingsDeveloper3 = WidgetSettingsDeveloper3.this;
            widgetSettingsDeveloper3.this$0.$experimentStore.setOverride(widgetSettingsDeveloper3.$registeredExperiment.getName(), i);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsDeveloper3 widgetSettingsDeveloper3 = WidgetSettingsDeveloper3.this;
            widgetSettingsDeveloper3.this$0.$experimentStore.clearOverride(widgetSettingsDeveloper3.$registeredExperiment.getName());
        }
    }

    public WidgetSettingsDeveloper3(ExperimentRegistry2 experimentRegistry2, WidgetSettingsDeveloper.AnonymousClass1 anonymousClass1, Map map) {
        this.$registeredExperiment = experimentRegistry2;
        this.this$0 = anonymousClass1;
        this.$allOverrides$inlined = map;
        this.name = experimentRegistry2.getReadableName();
        this.apiName = experimentRegistry2.getName();
        this.overrideBucket = (Integer) map.get(experimentRegistry2.getName());
        this.bucketDescriptions = experimentRegistry2.getBuckets();
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public String getApiName() {
        return this.apiName;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public List<String> getBucketDescriptions() {
        return this.bucketDescriptions;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public String getName() {
        return this.name;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Function0<Unit> getOnOverrideBucketCleared() {
        return this.onOverrideBucketCleared;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Function1<Integer, Unit> getOnOverrideBucketSelected() {
        return this.onOverrideBucketSelected;
    }

    @Override // com.discord.widgets.settings.developer.ExperimentOverridesAdapter.Item
    public Integer getOverrideBucket() {
        return this.overrideBucket;
    }
}
