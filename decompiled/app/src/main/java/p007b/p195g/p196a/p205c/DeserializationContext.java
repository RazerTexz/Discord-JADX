package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p198b.StreamReadCapability;
import p007b.p195g.p196a.p198b.p204t.JacksonFeatureSet;
import p007b.p195g.p196a.p205c.p206a0.DeserializerCache;
import p007b.p195g.p196a.p205c.p206a0.DeserializerFactory;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.LinkedNode;

/* JADX INFO: renamed from: b.g.a.c.g, reason: use source file name */
/* JADX INFO: compiled from: DeserializationContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializationContext extends DatabindContext implements Serializable {
    private static final long serialVersionUID = 1;
    public final DeserializerCache _cache;
    public final DeserializationConfig _config;
    public LinkedNode<JavaType> _currentType;
    public final DeserializerFactory _factory;
    public final int _featureFlags;
    public final InjectableValues _injectableValues;
    public final JacksonFeatureSet<StreamReadCapability> _readCapabilities;
    public final Class<?> _view;

    public DeserializationContext(DeserializerFactory deserializerFactory, DeserializerCache deserializerCache) {
        Objects.requireNonNull(deserializerFactory, "Cannot pass null DeserializerFactory");
        this._factory = deserializerFactory;
        this._cache = deserializerCache == null ? new DeserializerCache() : deserializerCache;
        this._featureFlags = 0;
        this._readCapabilities = null;
        this._config = null;
        this._view = null;
    }

    @Override // p007b.p195g.p196a.p205c.DatabindContext
    /* JADX INFO: renamed from: d */
    public final TypeFactory mo1940d() {
        return this._config._base._typeFactory;
    }

    @Override // p007b.p195g.p196a.p205c.DatabindContext
    /* JADX INFO: renamed from: f */
    public <T> T mo1942f(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException((JsonParser) null, str, javaType);
    }
}
