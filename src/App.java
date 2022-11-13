import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.project.dao.BusDao;
import com.project.dao.BusDaoImpl;
import com.project.dao.TicketsDao;
import com.project.dao.TicketsDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;
import com.project.exception.BusException;
import com.project.exception.TicketException;
import com.project.exception.UserException;
import com.project.model.Bus;
import com.project.model.Tickets;
import com.project.model.User;
import com.project.usecase.AdminLogin;
import com.project.usecase.CustomerRegistration;
import com.project.usecase.UserLogin;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("Welcome to Bus Ticket reservation system");
		System.out.println("========================================");
		System.out.println("");

		System.out.println("1. New customers - Register yourself");
		System.out.println("2. Existing customer - Login here");
		System.out.println("3. Admin login");
		System.out.println("4. Exit");

		int choice = sc.nextInt();

		while (choice != 4) {
			switch (choice) {
			case 1:
				System.out.println("Enter your name");
				String unameReg = sc.next();

				System.out.println("Enter the email");
				String emailReg = sc.next();

				System.out.println("Enter the Password");
				String passwordReg = sc.next();
				System.out.println();

				UserDao udao = new UserDaoImpl();
				User u1 = new User();
				u1.setUname(unameReg);
				u1.setEmail(emailReg);
				u1.setPassword(passwordReg);

				String str = null;
				try {
					str = udao.customerRegistration(u1);
					System.out.println(str);
					System.out.println();
				} catch (UserException e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:

				System.out.println("Enter your email");
				String email = sc.next();

				System.out.println("Enter your password");
				String password = sc.next();

				UserDao uDao = new UserDaoImpl();

				try {
					User user = uDao.userLogin(email, password);
					System.out.println("Welcome " + user.getUname());
					System.out.println();
					System.out.println("1. Check the bus data");
					System.out.println("2. check the bus data on the basis of starting point and destination");
					System.out.println("3. Book tickets");
					System.out.println("4. Check booked tickets");
					System.out.println("5. LogOut");
					int choice2 = sc.nextInt();
					while (choice2 != 5) {
						switch (choice2) {
						case 1:
							BusDao b1 = new BusDaoImpl();

							try {
								List<Bus> list = b1.showALLTravelSchedule();
								System.out.println("Bus id" + "    " + "Starting point" + "    " + "Destination"
										+ "    " + "Departure data & time" + "    " + "Arrival date & time" + "    "
										+ "Seats Available");
								for (Bus i : list) {
									int bid = i.getBid();
									String startingPoint = i.getDestinationFrom();
									String desPoint = i.getDestinationTo();
									String departure = i.getDeparture();
									String arrival = i.getArrival();
									int seatsAvailable = i.getSeatsAvailable();

									System.out.printf("%2d", bid);
									System.out.printf("%16s", startingPoint.toUpperCase());
									System.out.printf("%20s      ", desPoint.toUpperCase());

									System.out.printf("%15s     ", departure);
									System.out.printf("%15s", arrival);
									System.out.printf("%10d", seatsAvailable);
									System.out.println();

								}

								System.out.println();

							} catch (BusException e) {
								System.out.println(e.getMessage());

							}

							break;
						case 2:
							System.out.println("Enter Starting Point");
							String startPoint = sc.next();
							System.out.println("Enter Your Destination");
							String DestinationTO = sc.next();

							BusDao b11 = new BusDaoImpl();

							try {
								List<Bus> list = b11.showTravelDetailsRoute(startPoint, DestinationTO);
								System.out.println("Bus id" + "    " + "Starting point" + "    " + "Destination"
										+ "    " + "Departure data & time" + "    " + "Arrival date & time" + "    "
										+ "Seats Available");
								for (Bus i : list) {
									int bid = i.getBid();
									String startingPoint = i.getDestinationFrom();
									String desPoint = i.getDestinationTo();
									String departure = i.getDeparture();
									String arrival = i.getArrival();
									int seatsAvailable = i.getSeatsAvailable();

									System.out.printf("%2d", bid);
									System.out.printf("%16s", startingPoint.toUpperCase());
									System.out.printf("%18s        ", desPoint.toUpperCase());

									System.out.printf("%15s    ", departure);
									System.out.printf("%15s", arrival);
									System.out.printf("%10d", seatsAvailable);
									System.out.println();

								}

								System.out.println();
							} catch (BusException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}

							break;
						case 3:
							System.out.println("Please enter the Bus id");
							int bid = sc.nextInt();
							BusDao b111 = new BusDaoImpl();

							try {
								Bus bus = b111.ShowDetailsAsPerbid(bid);
								System.out.println("Bus id" + "    " + "Starting point" + "    " + "Destination"
										+ "    " + "Departure data & time" + "    " + "Arrival date & time" + "    "
										+ "Seats Available");
								int bid1 = bus.getBid();
								String startingPoint = bus.getDestinationFrom();
								String desPoint = bus.getDestinationTo();
								String departure = bus.getDeparture();
								String arrival = bus.getArrival();
								int seatsAvailable = bus.getSeatsAvailable();

								System.out.printf("%2d", bid1);
								System.out.printf("%17s", startingPoint.toUpperCase());
								System.out.printf("%18s        ", desPoint.toUpperCase());
								System.out.printf("%15s    ", departure);
								System.out.printf("%15s", arrival);
								System.out.printf("%10d", seatsAvailable);
								System.out.println();
								System.out.println();

								// on the basis of bid received the details of that bus
								System.out.println("Please enter the number of tickets you want to book");
								int seat = sc.nextInt();
								if (seat <= 0) {
									System.out.println("Tickets must be more than 0");
								} else if (bus.getSeatsAvailable() - seat < 0) {
									System.out.println("Invalid only " + bus.getSeatsAvailable()
											+ " tickets are availbale to book");
								} else {
									System.out.println("Please share the passanget details");
									String refID = bus.getSeatsAvailable() + "" + bus.getBid() + ""
											+ java.time.LocalDate.now();
									for (int i = 0; i < seat; i++) {
										System.out.println("Enter the name of Passanger");
										String pname = sc.next();
										System.out.println("Enter the age of the passanger");
										int age = sc.nextInt();

										// save booking details
										TicketsDao tdao = new TicketsDaoImpl();
										Tickets t1 = new Tickets();
										t1.setReferenceID(refID);
										t1.setBid(bus.getBid());
										t1.setPassangerName(pname);
										t1.setPassangerAge(age);
										t1.setDestinationFrom(bus.getDestinationFrom());
										t1.setDestinationTo(bus.getDestinationTo());
										t1.setDeparture(bus.getDeparture());
										t1.setArrival(bus.getArrival());
										t1.setEmail(email);// hardcode change it
										try {
											tdao.bookingData(t1);
										} catch (TicketException e) {

											System.out.println(e.getMessage());
										}
									}

									System.out.println("you have booked your tickets");
									// after successfull booking
									BusDao update = new BusDaoImpl();
									update.updateSeats(seat, bid);

									// print ticket details

									TicketsDao t1 = new TicketsDaoImpl();

									try {
										List<Tickets> list2 = t1.PrintTickets(refID, email);
										String refID1 = null;
										String startPoint1 = null;
										String destinatio = null;
										String departure1 = null;
										String arrival1 = null;
										Map<String, Integer> map = new HashMap<>();

										for (Tickets i : list2) {
											refID1 = i.getReferenceID();
											startPoint1 = i.getDestinationFrom();
											destinatio = i.getDestinationTo();
											departure1 = i.getDeparture();
											arrival1 = i.getArrival();
											map.put(i.getPassangerName(), i.getPassangerAge());
										}

										System.out.println("==================================================");
										System.out.println("                  Bus Ticket");
										System.out.println("==================================================");
										System.out.printf("Reference id                  :" + "%-20s\n", refID);
										System.out.printf("Starting point                :" + "%-20s\n", startPoint1);
										System.out.printf("Destination point             :" + "%-20s\n", destinatio);
										System.out.printf("Departure date & time         :" + "%-20s\n", departure);
										System.out.printf("Arrival date & time           :" + "%-20s\n", arrival);
										System.out.println("==================================================");
										System.out.println("Passenger details");

										System.out.println("S.No.   Name of passanger      " + "Age");
										int i = 1;

										for (Entry<String, Integer> entry : map.entrySet()) {
											System.out.printf("%2d         ", i);
											System.out.printf("%8s            ", entry.getKey());
											System.out.printf("%-10d", entry.getValue());
											// System.out.println(i + ". " + entry.getKey()+ entry.getValue());
											i++;
											System.out.println();
										}
										System.out.println("==================================================");
										System.out.println();

									} catch (TicketException e) {
										System.out.println(e.getMessage());
									}

								}

							} catch (BusException e) {
								System.out.println(e.getMessage());
							}

							break;
						case 4:
							// show refid on the basis of email which is unique

							TicketsDao t1 = new TicketsDaoImpl();
							List<String> listRefId = t1.ShowRefID(email);

							if (listRefId.isEmpty()) {
								System.out.println("No tickets found");
							} else {
								for (String s : listRefId) {
									System.out.println(s);
								}

								// Serach on the basis of ref id
								System.out.println("Enter the refernce id");
								String refId = sc.next();
								TicketsDao t11 = new TicketsDaoImpl();

								try {
									List<Tickets> list2 = t1.PrintTickets(refId, email);

									String refID = null;
									String startPoint1 = null;
									String destinatio = null;
									String departure = null;
									String arrival = null;
									Map<String, Integer> map = new HashMap<>();

									for (Tickets i : list2) {
										refID = i.getReferenceID();
										startPoint1 = i.getDestinationFrom();
										destinatio = i.getDestinationTo();
										departure = i.getDeparture();
										arrival = i.getArrival();
										map.put(i.getPassangerName(), i.getPassangerAge());
									}

									System.out.println("==================================================");
									System.out.println("                  Bus Ticket");
									System.out.println("==================================================");
									System.out.printf("Reference id                  :" + "%-20s\n", refID);
									System.out.printf("Starting point                :" + "%-20s\n", startPoint1);
									System.out.printf("Destination point             :" + "%-20s\n", destinatio);
									System.out.printf("Departure date & time         :" + "%-20s\n", departure);
									System.out.printf("Arrival date & time           :" + "%-20s\n", arrival);
									System.out.println("==================================================");
									System.out.println("Passenger details");

									System.out.println("S.No.   Name of passanger      " + "Age");
									int i = 1;

									for (Entry<String, Integer> entry : map.entrySet()) {
										System.out.printf("%2d         ", i);
										System.out.printf("%8s            ", entry.getKey());
										System.out.printf("%-10d", entry.getValue());
										// System.out.println(i + ". " + entry.getKey()+ entry.getValue());
										i++;
										System.out.println();
									}
									System.out.println("==================================================");
									System.out.println();

								} catch (TicketException e) {
									System.out.println(e.getMessage());
								}

							}
							System.out.println();

							break;
						default:
							System.out.println("Invalid option");
						}
						System.out.println("1. Check the bus data");
						System.out.println("2. check the bus data on the basis of starting point and destination");
						System.out.println("3. Book tickets");
						System.out.println("4. Check booked tickets");
						System.out.println("5. LogOut");

						choice2 = sc.nextInt();
					}

				} catch (UserException e) {
					System.out.println(e.getMessage());
					System.out.println();
					// e.printStackTrace();

				}

				break;
			case 3:
				System.out.println("Enter your email");
				String email1 = sc.next();

				System.out.println("Enter your password");
				String password1 = sc.next();

				UserDao uDao1 = new UserDaoImpl();
				User user1 = null;
				try {
					user1 = uDao1.userLogin(email1, password1);
				} catch (UserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Welcome " + user1.getUname());
				System.out.println();

				System.out.println("1. Check the available bus routes");
				System.out.println("2. List the additional new routes");
				System.out.println("3. Logout");

				int choice3 = sc.nextInt();
				while (choice3 != 3) {

					switch (choice3) {
					case 1:

						BusDao b1 = new BusDaoImpl();

						try {
							List<Bus> list = b1.showALLTravelSchedule();
							System.out.println("Bus id" + "    " + "Starting point" + "    " + "Destination" + "    "
									+ "Departure data & time" + "    " + "Arrival date & time" + "    "
									+ "Seats Available");
							for (Bus i : list) {
								int bid = i.getBid();
								String startingPoint = i.getDestinationFrom();
								String desPoint = i.getDestinationTo();
								String departure = i.getDeparture();
								String arrival = i.getArrival();
								int seatsAvailable = i.getSeatsAvailable();

								System.out.printf("%2d", bid);
								System.out.printf("%16s", startingPoint.toUpperCase());
								System.out.printf("%20s      ", desPoint.toUpperCase());

								System.out.printf("%15s     ", departure);
								System.out.printf("%15s", arrival);
								System.out.printf("%10d", seatsAvailable);
								System.out.println();

							}

							System.out.println();

						} catch (BusException e) {
							System.out.println(e.getMessage());

						}

						break;
					case 2:
						System.out.println("Enter the start location");
						String destinationFrom = sc.next();

						System.out.println("Enter the destination to");
						String destinationTo = sc.next();

						System.out.println("Enter the departure date yyyy-mm-dd");
						String dD = sc.next();
						System.out.println("Enter the departure time HH:MM:SS ");
						String dT = sc.next();

						System.out.println("Enter the arrival date yyyy-mm-dd");
						String aD = sc.next();
						System.out.println("Enter the arrival time in hh:mm:ss");
						String aT = sc.next();

						System.out.println("Seats available");
						int sA = sc.nextInt();

						BusDao dao = new BusDaoImpl();
						Bus b12 = new Bus();
						b12.setDestinationFrom(destinationFrom);
						b12.setDestinationTo(destinationTo);
						b12.setDeparture(dD + " " + dT);
						b12.setArrival(aD + " " + aT);
						b12.setSeatsAvailable(sA);

						// System.out.println(b1);

						try {
							String msg = dao.addBusDetails(b12);
							System.out.println(msg);
						} catch (BusException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					default:
					}
					System.out.println("1. Check the available bus routes");
					System.out.println("2. List the additional new routes");
					System.out.println("3. Logout");

					choice3 = sc.nextInt();
				}

				break;
			default:

			}
			System.out.println("1. New customers - Register yourself");
			System.out.println("2. Existing customer - Login here");
			System.out.println("3. Admin login");
			System.out.println("4. Exit");
			choice = sc.nextInt();

		}
		System.out.println("Thankyou for visiting");

	}

}
