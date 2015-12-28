package com.parabul.adviser.dao.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCarInfo is a Querydsl query type for CarInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCarInfo extends EntityPathBase<CarInfo> {

    private static final long serialVersionUID = -310240105L;

    public static final QCarInfo carInfo = new QCarInfo("carInfo");

    public final StringPath condition = createString("condition");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> manufactureyear = createNumber("manufactureyear", Integer.class);

    public final NumberPath<Integer> mileage = createNumber("mileage", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath transmissiontype = createString("transmissiontype");

    public QCarInfo(String variable) {
        super(CarInfo.class, forVariable(variable));
    }

    public QCarInfo(Path<? extends CarInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarInfo(PathMetadata<?> metadata) {
        super(CarInfo.class, metadata);
    }

}

