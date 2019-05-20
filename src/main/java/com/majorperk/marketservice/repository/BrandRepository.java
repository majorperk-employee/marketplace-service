package com.majorperk.marketservice.repository;

import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_DESC_SHORT;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_ID;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_IMG_URLS;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_KEY;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_NAME;
import static com.majorperk.marketservice.utils.Constants.BRAND_OBJECT_STATUS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.majorperk.marketservice.model.reward.Brand;
import com.majorperk.marketservice.model.reward.SmallBrand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
<<<<<<< HEAD
    List<Brand> findAll();

    String FIND_ALL_CONDENSED = "SELECT new " +
        "com.majorperk.marketservice.model.reward.SmallBrand" +
        "(" + BRAND_OBJECT_ID + ", " + 
            BRAND_OBJECT_KEY + ", " + 
            BRAND_OBJECT_NAME + ", " + 
            BRAND_OBJECT_DESC_SHORT + ", " + 
            BRAND_OBJECT_STATUS + ", " + 
            BRAND_OBJECT_IMG_URLS +
        ") FROM " + BRAND_OBJECT +
        " WHERE status ='active'";

    // @Query("SELECT new com.majorperk.marketservice.model.reward.SmallBrand(id, brandKey, brandName, shortDescription, status, imageUrls) FROM Brand WHERE status='active'")
    @Query(FIND_ALL_CONDENSED)
    public List<SmallBrand> findAllCondensed();
=======
	List<Brand> findAll();

	String FIND_ALL_CONDENSED = "SELECT new " + "com.majorperk.marketservice.model.reward.SmallBrand" + "("
			+ BRAND_OBJECT_ID + ", " + BRAND_OBJECT_KEY + ", " + BRAND_OBJECT_NAME + ", " + BRAND_OBJECT_DESC_SHORT
			+ ", " + BRAND_OBJECT_STATUS + ", " + BRAND_OBJECT_IMG_URLS + ") FROM " + BRAND_OBJECT
			+ " WHERE status ='active'";

	// @Query("SELECT new com.majorperk.marketservice.model.reward.SmallBrand(id,
	// brandKey, brandName, shortDescription, status, imageUrls) FROM Brand WHERE
	// status='active'")
	@Query(FIND_ALL_CONDENSED)
	public List<SmallBrand> findAllCondensed();

	Brand findFirstByBrandName(String brandName);

	Brand findFirstByBrandKey(String brandKey);
>>>>>>> 17e83b556f07a022f4c0b6321e31cd33d1112bf4
}