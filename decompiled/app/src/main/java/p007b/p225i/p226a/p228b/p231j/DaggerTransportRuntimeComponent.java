package p007b.p225i.p226a.p228b.p231j;

import android.content.Context;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.ExecutionModule_ExecutorFactory;
import p007b.p225i.p226a.p228b.p231j.p232q.CreationContextFactory_Factory;
import p007b.p225i.p226a.p228b.p231j.p232q.MetadataBackendRegistry_Factory;
import p007b.p225i.p226a.p228b.p231j.p233r.p234a.DoubleCheck;
import p007b.p225i.p226a.p228b.p231j.p233r.p234a.InstanceFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.DefaultScheduler3;
import p007b.p225i.p226a.p228b.p231j.p236t.DefaultScheduler_Factory;
import p007b.p225i.p226a.p228b.p231j.p236t.SchedulingConfigModule_ConfigFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.SchedulingModule_WorkSchedulerFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader6;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader_Factory;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkInitializer3;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkInitializer_Factory;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkScheduler;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.C2511t;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStoreModule_DbNameFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStoreModule_SchemaVersionFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStoreModule_StoreConfigFactory;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.SQLiteEventStore_Factory;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.SchemaManager_Factory;
import p007b.p225i.p226a.p228b.p231j.p240v.TimeModule_EventClockFactory;
import p007b.p225i.p226a.p228b.p231j.p240v.TimeModule_UptimeClockFactory;
import p496c0.p497a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.c, reason: use source file name */
/* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {

    /* JADX INFO: renamed from: j */
    public Provider3<Executor> f5264j;

    /* JADX INFO: renamed from: k */
    public Provider3<Context> f5265k;

    /* JADX INFO: renamed from: l */
    public Provider3 f5266l;

    /* JADX INFO: renamed from: m */
    public Provider3 f5267m;

    /* JADX INFO: renamed from: n */
    public Provider3 f5268n;

    /* JADX INFO: renamed from: o */
    public Provider3<C2511t> f5269o;

    /* JADX INFO: renamed from: p */
    public Provider3<SchedulerConfig> f5270p;

    /* JADX INFO: renamed from: q */
    public Provider3<WorkScheduler> f5271q;

    /* JADX INFO: renamed from: r */
    public Provider3<DefaultScheduler3> f5272r;

    /* JADX INFO: renamed from: s */
    public Provider3<Uploader6> f5273s;

    /* JADX INFO: renamed from: t */
    public Provider3<WorkInitializer3> f5274t;

    /* JADX INFO: renamed from: u */
    public Provider3<TransportRuntime> f5275u;

    public DaggerTransportRuntimeComponent(Context context, a aVar) {
        Provider3<Executor> provider3 = ExecutionModule_ExecutorFactory.a.f5278a;
        Object obj = DoubleCheck.f5325a;
        this.f5264j = provider3 instanceof DoubleCheck ? provider3 : new DoubleCheck(provider3);
        Objects.requireNonNull(context, "instance cannot be null");
        InstanceFactory instanceFactory = new InstanceFactory(context);
        this.f5265k = instanceFactory;
        TimeModule_EventClockFactory timeModule_EventClockFactory = TimeModule_EventClockFactory.a.f5459a;
        TimeModule_UptimeClockFactory timeModule_UptimeClockFactory = TimeModule_UptimeClockFactory.a.f5460a;
        CreationContextFactory_Factory creationContextFactory_Factory = new CreationContextFactory_Factory(instanceFactory, timeModule_EventClockFactory, timeModule_UptimeClockFactory);
        this.f5266l = creationContextFactory_Factory;
        Provider3 metadataBackendRegistry_Factory = new MetadataBackendRegistry_Factory(instanceFactory, creationContextFactory_Factory);
        this.f5267m = metadataBackendRegistry_Factory instanceof DoubleCheck ? metadataBackendRegistry_Factory : new DoubleCheck(metadataBackendRegistry_Factory);
        SchemaManager_Factory schemaManager_Factory = new SchemaManager_Factory(this.f5265k, EventStoreModule_DbNameFactory.a.f5421a, EventStoreModule_SchemaVersionFactory.a.f5422a);
        this.f5268n = schemaManager_Factory;
        SQLiteEventStore_Factory sQLiteEventStore_Factory = new SQLiteEventStore_Factory(timeModule_EventClockFactory, timeModule_UptimeClockFactory, EventStoreModule_StoreConfigFactory.a.f5423a, schemaManager_Factory);
        Provider3<C2511t> doubleCheck = sQLiteEventStore_Factory instanceof DoubleCheck ? sQLiteEventStore_Factory : new DoubleCheck<>(sQLiteEventStore_Factory);
        this.f5269o = doubleCheck;
        SchedulingConfigModule_ConfigFactory schedulingConfigModule_ConfigFactory = new SchedulingConfigModule_ConfigFactory(timeModule_EventClockFactory);
        this.f5270p = schedulingConfigModule_ConfigFactory;
        Provider3<Context> provider32 = this.f5265k;
        SchedulingModule_WorkSchedulerFactory schedulingModule_WorkSchedulerFactory = new SchedulingModule_WorkSchedulerFactory(provider32, doubleCheck, schedulingConfigModule_ConfigFactory, timeModule_UptimeClockFactory);
        this.f5271q = schedulingModule_WorkSchedulerFactory;
        Provider3<Executor> provider33 = this.f5264j;
        Provider3 provider34 = this.f5267m;
        DefaultScheduler_Factory defaultScheduler_Factory = new DefaultScheduler_Factory(provider33, provider34, schedulingModule_WorkSchedulerFactory, doubleCheck, doubleCheck);
        this.f5272r = defaultScheduler_Factory;
        Uploader_Factory uploader_Factory = new Uploader_Factory(provider32, provider34, doubleCheck, schedulingModule_WorkSchedulerFactory, provider33, doubleCheck, timeModule_EventClockFactory);
        this.f5273s = uploader_Factory;
        WorkInitializer_Factory workInitializer_Factory = new WorkInitializer_Factory(provider33, doubleCheck, schedulingModule_WorkSchedulerFactory, doubleCheck);
        this.f5274t = workInitializer_Factory;
        Provider3<TransportRuntime> transportRuntime_Factory = new TransportRuntime_Factory(timeModule_EventClockFactory, timeModule_UptimeClockFactory, defaultScheduler_Factory, uploader_Factory, workInitializer_Factory);
        this.f5275u = transportRuntime_Factory instanceof DoubleCheck ? transportRuntime_Factory : new DoubleCheck(transportRuntime_Factory);
    }
}
