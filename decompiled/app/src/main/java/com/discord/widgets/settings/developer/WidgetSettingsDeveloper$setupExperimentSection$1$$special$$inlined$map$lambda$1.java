package com.discord.widgets.settings.developer;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.experiments.RegisteredExperiment;
import com.discord.widgets.settings.developer.ExperimentOverridesAdapter;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import d0.z.d.o;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsDeveloper.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 implements ExperimentOverridesAdapter.Item {
    public final /* synthetic */ Map $allOverrides$inlined;
    public final /* synthetic */ RegisteredExperiment $registeredExperiment;
    private final String apiName;
    private final List<String> bucketDescriptions;
    private final String name;
    private final Integer overrideBucket;
    public final /* synthetic */ WidgetSettingsDeveloper.AnonymousClass1 this$0;
    private final Function1<Integer, Unit> onOverrideBucketSelected = new AnonymousClass1();
    private final Function0<Unit> onOverrideBucketCleared = new AnonymousClass2();

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 = WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this;
            widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this$0.$experimentStore.setOverride(widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.$registeredExperiment.getName(), i);
        }
    }

    /* compiled from: WidgetSettingsDeveloper.kt */
    /* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
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
            WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 = WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this;
            widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this$0.$experimentStore.clearOverride(widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.$registeredExperiment.getName());
        }
    }

    public WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1(RegisteredExperiment registeredExperiment, WidgetSettingsDeveloper.AnonymousClass1 anonymousClass1, Map map) {
        this.$registeredExperiment = registeredExperiment;
        this.this$0 = anonymousClass1;
        this.$allOverrides$inlined = map;
        this.name = registeredExperiment.getReadableName();
        this.apiName = registeredExperiment.getName();
        this.overrideBucket = (Integer) map.get(registeredExperiment.getName());
        this.bucketDescriptions = registeredExperiment.getBuckets();
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
