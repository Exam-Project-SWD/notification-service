# Notification service

This service is responsible for sending notifications to users.

Currently, it can send emails, but an SMS service would be nice to add in the future.

## Events

The service listens to certain Kafka events, e.g. when a user is deleted, or bad weather is detected at the
delivery address for an address, and sends a notification to the user. This can easily be expanded to include other
events.

- `BAD_WEATHER`
- `CHANGED_CUSTOMER`
- `DELETED_CUSTOMER`

## Database

Its database includes users and their contact details. This data is synced with the customer service, so that changes
there are reflected here.

Newly created users are included in the `CHANGED_CUSTOMER` event. This could be changed in the future to send specific
notifications about changed contact details.

## Notifications

The messages can be customized based on the event, and filled out with user details, like their name.

It would be fun to use different templates for different types of weather, but it currently uses the same template.
